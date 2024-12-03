package io.knowk.example.feature.home.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.knowk.example.core.domain.usecase.DeleteFavoriteStoreUseCase
import io.knowk.example.core.domain.usecase.FetchStoresUseCase
import io.knowk.example.core.domain.usecase.GetFavoriteStoresUseCase
import io.knowk.example.core.domain.usecase.InsertFavoriteStoreUseCase
import io.knowk.example.core.model.Store
import io.knowk.example.feature.home.ui.model.StoreCardUiModel
import io.knowk.example.feature.home.ui.model.mapper.toCardUiModel
import io.knowk.example.feature.home.ui.model.mapper.toModel
import javax.inject.Inject
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    fetchStoresUseCase: FetchStoresUseCase,
    getFavoriteStoresUseCase: GetFavoriteStoresUseCase,
    private val insertFavoriteStoreUseCase: InsertFavoriteStoreUseCase,
    private val deleteFavoriteStoreUseCase: DeleteFavoriteStoreUseCase,
) : ViewModel() {
    private val _title: MutableStateFlow<String> = MutableStateFlow("")
    val title: StateFlow<String> = _title.asStateFlow()

    private val remoteStores: Flow<List<Store>> = fetchStoresUseCase()
        .mapNotNull { stores -> stores }
        .map { stores ->
            _title.update { stores.title }
            stores.list
        }

    private val favoriteStoresSet: Flow<Set<Store>> = getFavoriteStoresUseCase()
        .map(List<Store>::toSet)

    val stores: StateFlow<PersistentList<StoreCardUiModel>?> = combine(
        remoteStores,
        favoriteStoresSet,
    ) { remoteStores, favoriteStoresSet ->
        remoteStores
            .map { store ->
                store
                    .toCardUiModel(
                        favorite = favoriteStoresSet.contains(store),
                    )
            }
            .toPersistentList()
    }
        .distinctUntilChanged()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null,
        )

    fun insertFavoriteStore(store: StoreCardUiModel) {
        viewModelScope
            .launch {
                insertFavoriteStoreUseCase(store.toModel())
            }
    }

    fun deleteFavoriteStore(store: StoreCardUiModel) {
        viewModelScope
            .launch {
                deleteFavoriteStoreUseCase(store.toModel())
            }
    }
}

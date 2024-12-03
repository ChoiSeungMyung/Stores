package io.knowk.example.feature.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.knowk.example.core.domain.usecase.DeleteFavoriteStoreUseCase
import io.knowk.example.core.domain.usecase.GetFavoriteStoresUseCase
import io.knowk.example.core.model.Store
import javax.inject.Inject
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    getAllFavoriteStoresUseCase: GetFavoriteStoresUseCase,
    private val deleteFavoriteStoreUseCase: DeleteFavoriteStoreUseCase,
) : ViewModel() {

    val favoriteStores: StateFlow<PersistentList<Store>> = getAllFavoriteStoresUseCase()
        .map(List<Store>::toPersistentList)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = persistentListOf(),
        )

    fun deleteFavoriteStore(store: Store) {
        viewModelScope.launch {
            deleteFavoriteStoreUseCase(store)
        }
    }
}

package io.knowk.example.core.domain.usecase

import dagger.Reusable
import io.knowk.example.core.data.repository.StoreRepository
import io.knowk.example.core.model.Store
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@Reusable
class GetFavoriteStoresUseCase @Inject constructor(
    private val repo: StoreRepository,
) {

    operator fun invoke(): Flow<List<Store>> {
        return repo.getAllFavoriteStore()
    }
}

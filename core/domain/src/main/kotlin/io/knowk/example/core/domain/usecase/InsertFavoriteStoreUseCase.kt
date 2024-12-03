package io.knowk.example.core.domain.usecase

import dagger.Reusable
import io.knowk.example.core.data.repository.StoreRepository
import io.knowk.example.core.model.Store
import javax.inject.Inject

@Reusable
class InsertFavoriteStoreUseCase @Inject constructor(
    private val repo: StoreRepository,
) {

    suspend operator fun invoke(store: Store) {
        repo.insertFavoriteStore(store)
    }
}

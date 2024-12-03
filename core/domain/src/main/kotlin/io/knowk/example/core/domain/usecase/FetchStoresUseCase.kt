package io.knowk.example.core.domain.usecase

import dagger.Reusable
import io.knowk.example.core.data.repository.StoreRepository
import io.knowk.example.core.model.Stores
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Reusable
class FetchStoresUseCase @Inject constructor(
    private val repo: StoreRepository,
) {

    operator fun invoke(): Flow<Stores?> {
        return flow {
            emit(repo.fetchStores())
        }
    }
}

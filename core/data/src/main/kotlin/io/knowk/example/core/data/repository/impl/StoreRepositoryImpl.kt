package io.knowk.example.core.data.repository.impl

import io.knowk.example.core.data.mapper.toFavoriteStoreEntity
import io.knowk.example.core.data.mapper.toModel
import io.knowk.example.core.data.repository.StoreRepository
import io.knowk.example.core.database.entity.FavoriteStoreEntity
import io.knowk.example.core.database.source.FavoriteStoresLocalSource
import io.knowk.example.core.model.Store
import io.knowk.example.core.model.Stores
import io.knowk.example.core.network.response.StoreResponse
import io.knowk.example.core.network.source.StoreRemoteSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreRepositoryImpl @Inject constructor(
    private val remote: StoreRemoteSource,
    private val favoriteStoreLocal: FavoriteStoresLocalSource,
) : StoreRepository {
    override suspend fun fetchStores(): Stores {
        val response = remote
            .fetchStores()
        val list = response.list.map(StoreResponse::toModel)

        return Stores(
            title = response.title,
            list = list,
        )
    }

    override fun getAllFavoriteStore(): Flow<List<Store>> {
        return favoriteStoreLocal
            .getAllFavoriteStores()
            .map { it.map(FavoriteStoreEntity::toModel) }
    }

    override suspend fun insertFavoriteStore(store: Store) {
        favoriteStoreLocal
            .insertFavoriteStore(
                favoriteStoreEntity = store.toFavoriteStoreEntity(),
            )
    }

    override suspend fun deleteFavoriteStore(store: Store) {
        favoriteStoreLocal
            .deleteFavoriteStore(
                favoriteStoreEntity = store.toFavoriteStoreEntity(),
            )
    }
}

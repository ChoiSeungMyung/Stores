package io.knowk.example.core.database.source.impl

import io.knowk.example.core.database.dao.FavoriteStoresDao
import io.knowk.example.core.database.entity.FavoriteStoreEntity
import io.knowk.example.core.database.source.FavoriteStoresLocalSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class FavoriteStoresLocalSourceImpl @Inject constructor(
    private val dao: FavoriteStoresDao,
) : FavoriteStoresLocalSource {

    override fun getAllFavoriteStores(): Flow<List<FavoriteStoreEntity>> {
        return dao.getAllFavoriteStores()
    }

    override suspend fun insertFavoriteStore(favoriteStoreEntity: FavoriteStoreEntity) {
        dao
            .insertFavoriteStore(
                favoriteStoreEntity = favoriteStoreEntity,
            )
    }

    override suspend fun deleteFavoriteStore(favoriteStoreEntity: FavoriteStoreEntity) {
        dao
            .deleteFavoriteStore(
                favoriteStoreEntity = favoriteStoreEntity,
            )
    }
}

package io.knowk.example.core.database.source

import io.knowk.example.core.database.entity.FavoriteStoreEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteStoresLocalSource {

    fun getAllFavoriteStores(): Flow<List<FavoriteStoreEntity>>

    suspend fun insertFavoriteStore(favoriteStoreEntity: FavoriteStoreEntity)

    suspend fun deleteFavoriteStore(favoriteStoreEntity: FavoriteStoreEntity)
}

package io.knowk.example.core.data.repository

import io.knowk.example.core.model.Store
import io.knowk.example.core.model.Stores
import kotlinx.coroutines.flow.Flow

interface StoreRepository {

    suspend fun fetchStores(): Stores?

    fun getAllFavoriteStore(): Flow<List<Store>>

    suspend fun insertFavoriteStore(store: Store)

    suspend fun deleteFavoriteStore(store: Store)
}

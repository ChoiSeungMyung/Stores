package io.knowk.example.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.knowk.example.core.database.entity.FavoriteStoreEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteStoresDao {
    @Query("SELECT * FROM favorite_stores")
    fun getAllFavoriteStores(): Flow<List<FavoriteStoreEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteStore(favoriteStoreEntity: FavoriteStoreEntity)

    @Delete
    suspend fun deleteFavoriteStore(favoriteStoreEntity: FavoriteStoreEntity)
}

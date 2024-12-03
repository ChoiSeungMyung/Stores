package io.knowk.example.core.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import io.knowk.example.core.database.dao.FavoriteStoresDao
import io.knowk.example.core.database.entity.FavoriteStoreEntity

@Database(
    entities = [FavoriteStoreEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class KnowkDatabase : RoomDatabase() {

    abstract fun favoriteStoresDao(): FavoriteStoresDao
}

package io.knowk.example.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_stores")
data class FavoriteStoreEntity(
    @PrimaryKey val code: String,
    val thumbnailUrl: String,
    val iconImageUrl: String,
    val name: String,
)

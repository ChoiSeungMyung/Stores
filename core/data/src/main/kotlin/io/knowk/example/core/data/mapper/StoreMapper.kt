package io.knowk.example.core.data.mapper

import io.knowk.example.core.database.entity.FavoriteStoreEntity
import io.knowk.example.core.model.Store
import io.knowk.example.core.network.response.FetchStoresResponse
import io.knowk.example.core.network.response.StoreResponse

fun FavoriteStoreEntity.toModel(): Store = Store(
    code = code,
    thumbnailUrl = thumbnailUrl,
    iconImageUrl = iconImageUrl,
    name = name,
)

fun Store.toFavoriteStoreEntity(): FavoriteStoreEntity = FavoriteStoreEntity(
    code = code,
    thumbnailUrl = thumbnailUrl,
    iconImageUrl = iconImageUrl,
    name = name,
)

fun StoreResponse.toModel(): Store = Store(
    code = code,
    thumbnailUrl = thumbnailUrl,
    iconImageUrl = iconImageUrl,
    name = name,
)

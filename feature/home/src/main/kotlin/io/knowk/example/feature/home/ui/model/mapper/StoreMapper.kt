package io.knowk.example.feature.home.ui.model.mapper

import io.knowk.example.core.model.Store
import io.knowk.example.feature.home.ui.model.StoreCardUiModel

fun Store.toCardUiModel(favorite: Boolean) = StoreCardUiModel(
    code = code,
    thumbnailUrl = thumbnailUrl,
    iconImageUrl = iconImageUrl,
    name = name,
    favorite = favorite,
)

fun StoreCardUiModel.toModel() = Store(
    code = code,
    thumbnailUrl = thumbnailUrl,
    iconImageUrl = iconImageUrl,
    name = name,
)

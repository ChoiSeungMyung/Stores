package io.knowk.example.feature.home.ui.preview

import io.knowk.example.feature.home.ui.model.StoreCardUiModel
import kotlinx.collections.immutable.toPersistentList

internal object PreviewUtil {

    fun mockStoreCardUiModels() = List(10) { index ->
        StoreCardUiModel(
            code = "$index",
            thumbnailUrl = "",
            iconImageUrl = "",
            name = "$index",
            favorite = index % 2 == 0,
        )
    }
        .toPersistentList()

    fun mockStoreCardUiModel() = StoreCardUiModel(
        code = "mock",
        thumbnailUrl = "",
        iconImageUrl = "",
        name = "mockUiModel",
        favorite = false,
    )
}

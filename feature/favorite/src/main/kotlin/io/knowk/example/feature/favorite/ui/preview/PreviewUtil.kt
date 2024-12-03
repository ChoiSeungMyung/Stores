package io.knowk.example.feature.favorite.ui.preview

import io.knowk.example.core.model.Store
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

internal object PreviewUtil {

    fun mockStores(): PersistentList<Store> = List(10) { index ->
        Store(
            code = "$index",
            thumbnailUrl = "",
            iconImageUrl = "",
            name = "$index",
        )
    }
        .toPersistentList()

    fun mockStore(): Store = Store(
        code = "mock",
        thumbnailUrl = "",
        iconImageUrl = "",
        name = "mock",
    )
}

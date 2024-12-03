package io.knowk.example.feature.home.ui.section

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import io.knowk.example.core.designsystem.component.EmptyScreen
import io.knowk.example.feature.home.ui.component.StoreCard
import io.knowk.example.feature.home.ui.model.StoreCardUiModel
import kotlinx.collections.immutable.PersistentList

fun LazyListScope.CardSection(
    stores: PersistentList<StoreCardUiModel>,
    onInsertFavoriteStore: (StoreCardUiModel) -> Unit,
    onDeleteFavoriteStore: (StoreCardUiModel) -> Unit,
) {
    if (stores.isEmpty()) {
        item {
            EmptyScreen()
        }
    } else {
        items(
            items = stores,
            key = { store -> store.code },
        ) { storeUiModel ->
            StoreCard(
                model = storeUiModel,
                onClickFavorite = {
                    if (storeUiModel.favorite) {
                        onDeleteFavoriteStore(storeUiModel)
                    } else {
                        onInsertFavoriteStore(storeUiModel)
                    }
                },
            )
        }
    }
}

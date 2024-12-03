package io.knowk.example.feature.favorite.ui.section

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import io.knowk.example.core.designsystem.component.EmptyScreen
import io.knowk.example.core.model.Store
import io.knowk.example.feature.favorite.ui.component.FavoriteCard
import kotlinx.collections.immutable.PersistentList

fun LazyListScope.CardSection(
    favoriteStores: PersistentList<Store>,
    onClickFavorite: (Store) -> Unit,
) {
    if (favoriteStores.isEmpty()) {
        item {
            EmptyScreen()
        }
    } else {
        items(
            items = favoriteStores,
            key = { store -> store.code },
        ) { store ->
            FavoriteCard(
                store = store,
                onClickFavorite = onClickFavorite,
            )
        }
    }
}

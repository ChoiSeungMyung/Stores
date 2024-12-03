package io.knowk.example.feature.favorite.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.knowk.example.core.designsystem.theme.KnowkColors
import io.knowk.example.core.model.Store
import io.knowk.example.feature.favorite.ui.preview.PreviewUtil

private const val NAME_MAX_LINES = 2

@Composable
internal fun FavoriteCard(
    store: Store,
    onClickFavorite: (Store) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        AsyncImage(
            model = store.thumbnailUrl,
            contentDescription = store.name,
            modifier = Modifier
                .size(72.dp),
        )

        Text(
            text = store.name,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            maxLines = NAME_MAX_LINES,
            modifier = Modifier
                .weight(1f),
        )

        Icon(
            imageVector = Icons.Default.Favorite,
            tint = KnowkColors.ORANGE,
            contentDescription = "favorite item",
            modifier = Modifier
                .size(32.dp)
                .clickable(onClick = { onClickFavorite(store) })
                .padding(4.dp),
        )
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
)
private fun FavoriteCardPreview() {
    MaterialTheme {
        FavoriteCard(
            store = PreviewUtil.mockStore(),
            onClickFavorite = {},
        )
    }
}

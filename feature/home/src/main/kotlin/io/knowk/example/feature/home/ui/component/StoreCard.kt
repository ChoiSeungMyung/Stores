package io.knowk.example.feature.home.ui.component

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.knowk.example.feature.home.ui.model.StoreCardUiModel
import io.knowk.example.feature.home.ui.preview.PreviewUtil

@Composable
internal fun StoreCard(
    model: StoreCardUiModel,
    onClickFavorite: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = 0.dp,
        modifier = modifier,
    ) {
        Column(
            verticalArrangement = spacedBy(4.dp),
        ) {
            StoreThumbnail(
                thumbnailUrl = model.thumbnailUrl,
                iconImageUrl = model.iconImageUrl,
                name = model.name,
            )

            StoreCardInfo(
                name = model.name,
                favorite = model.favorite,
                onClickFavorite = onClickFavorite,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
)
private fun StoreCardPreview() {
    MaterialTheme {
        StoreCard(
            model = PreviewUtil.mockStoreCardUiModel(),
            onClickFavorite = {},
        )
    }
}

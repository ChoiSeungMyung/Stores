package io.knowk.example.feature.home.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.knowk.example.core.designsystem.theme.KnowkColors

private const val NAME_MAX_LINES = 2

@Composable
internal fun StoreCardInfo(
    name: String,
    favorite: Boolean,
    onClickFavorite: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        val (favoriteIcon, favoriteColor) = if (favorite) {
            Icons.Default.Favorite to KnowkColors.ORANGE
        } else {
            Icons.Outlined.FavoriteBorder to Color.White
        }

        Text(
            text = name,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            maxLines = NAME_MAX_LINES,
            modifier = Modifier
                .weight(1f),
        )

        Icon(
            imageVector = favoriteIcon,
            tint = favoriteColor,
            contentDescription = "favorite is $favorite",
            modifier = Modifier
                .size(32.dp)
                .clickable(onClick = onClickFavorite)
                .padding(4.dp),
        )
    }
}

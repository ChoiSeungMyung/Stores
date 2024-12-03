package io.knowk.example.feature.home.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
internal fun StoreThumbnail(
    thumbnailUrl: String,
    iconImageUrl: String,
    name: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        AsyncImage(
            model = thumbnailUrl,
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.33f),
        )

        AsyncImage(
            model = iconImageUrl,
            contentDescription = "$name icon",
            modifier = Modifier
                .padding(12.dp)
                .size(48.dp)
                .clip(CircleShape),
        )
    }
}

package io.knowk.example.feature.main.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
internal fun MainBottomBarLabel(
    label: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = if (selected) {
        Color.Black
    } else {
        Color.White
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color = backgroundColor)
    ) {
        Text(
            text = label,
        )
    }
}

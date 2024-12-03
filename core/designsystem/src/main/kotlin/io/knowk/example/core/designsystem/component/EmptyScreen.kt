package io.knowk.example.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import io.knowk.example.core.designsystem.R

@Composable
fun EmptyScreen(
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize(),
    ) {
        Text(
            text = stringResource(R.string.empty_result),
            color = textColor,
        )
    }
}

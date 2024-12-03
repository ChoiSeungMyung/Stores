package io.knowk.example.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HeadLine(
    title: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            color = textColor,
        )
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0x00000000,
)
private fun HeadLinePreview() {
    MaterialTheme {
        HeadLine(
            title = "똑똑, 동네 맛집이 도착했어요",
        )
    }
}

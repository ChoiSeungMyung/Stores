package io.knowk.example.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint
import io.knowk.example.presentation.navigation.PresentationNavHost

@AndroidEntryPoint
class PresentationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colors = MaterialTheme
                    .colors
                    .copy(
                        background = Color.Black,
                        surface = Color.Black,
                    ),
            ) {
                PresentationNavHost(
                    modifier =
                    Modifier
                        .fillMaxSize(),
                )
            }
        }
    }
}

package io.knowk.example.feature.main.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import io.knowk.example.feature.main.R

enum class MainTabState {
    HOME,
    FAVORITE,
    ;

    val label: String
        @Composable
        get() = when (this) {
            HOME -> stringResource(R.string.label_home)
            FAVORITE -> stringResource(R.string.label_favorite_store)
        }
}

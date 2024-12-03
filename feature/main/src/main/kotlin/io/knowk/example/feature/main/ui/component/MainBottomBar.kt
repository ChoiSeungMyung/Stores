package io.knowk.example.feature.main.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.knowk.example.feature.main.ui.state.MainTabState

@Composable
internal fun MainBottomBar(
    currentTab: MainTabState?,
    navigate: (MainTabState) -> Unit,
    modifier: Modifier = Modifier,
) {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.background,
        contentPadding = PaddingValues(0.dp),
        modifier = modifier,
    ) {
        MainTabState
            .entries
            .forEach { tab ->
                val selected = currentTab == tab

                BottomNavigationItem(
                    selected = selected,
                    icon = {
                        MainBottomBarLabel(
                            label = tab.label,
                            selected = selected,
                        )
                    },
                    onClick = {
                        if (!selected) {
                            navigate(tab)
                        }
                    },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.Black,
                )
            }
    }
}

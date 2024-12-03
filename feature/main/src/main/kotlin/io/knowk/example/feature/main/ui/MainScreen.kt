package io.knowk.example.feature.main.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import io.knowk.example.feature.favorite.navigation.FAVORITE_ROUTE
import io.knowk.example.feature.favorite.navigation.navigateFavorite
import io.knowk.example.feature.home.navigation.HOME_ROUTE
import io.knowk.example.feature.home.navigation.navigateHome
import io.knowk.example.feature.main.navigaion.MainNavHost
import io.knowk.example.feature.main.ui.component.MainBottomBar
import io.knowk.example.feature.main.ui.state.MainTabState

@Composable
internal fun MainRoute(
    navHostController: NavHostController,
) {
    MainScreen(
        navHostController = navHostController,
    )
}

@Composable
private fun MainScreen(
    navHostController: NavHostController,
) {
    Scaffold(
        bottomBar = {
            MainBottomBar(
                currentTab = navHostController.currentTab,
                navigate = { tab ->
                    when (tab) {
                        MainTabState.HOME -> navHostController.navigateHome()
                        MainTabState.FAVORITE -> navHostController.navigateFavorite()
                    }
                },
            )
        },
        content = { paddingValues ->
            MainNavHost(
                navHostController = navHostController,
                modifier = Modifier
                    .padding(paddingValues),
            )
        },
    )
}

private val NavHostController.currentTab
    @Composable
    get() = when (currentBackStackEntryAsState().value?.destination?.route) {
        HOME_ROUTE -> MainTabState.HOME
        FAVORITE_ROUTE -> MainTabState.FAVORITE
        else -> null
    }

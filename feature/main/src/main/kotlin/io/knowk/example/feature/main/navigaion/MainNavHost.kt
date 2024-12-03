package io.knowk.example.feature.main.navigaion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.knowk.example.feature.favorite.navigation.favoriteScreen
import io.knowk.example.feature.home.navigation.HOME_ROUTE
import io.knowk.example.feature.home.navigation.homeScreen

@Composable
internal fun MainNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = HOME_ROUTE,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen()
        favoriteScreen()
    }
}

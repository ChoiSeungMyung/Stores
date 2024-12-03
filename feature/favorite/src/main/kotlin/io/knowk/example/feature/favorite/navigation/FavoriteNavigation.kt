package io.knowk.example.feature.favorite.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.knowk.example.feature.favorite.ui.FavoriteRoute

const val FAVORITE_ROUTE = "favoriteRoute"

fun NavController.navigateFavorite() {
    navigate(FAVORITE_ROUTE) {
        restoreState = true
        launchSingleTop = true
        popUpTo(FAVORITE_ROUTE)
    }
}

fun NavGraphBuilder.favoriteScreen() {
    composable(
        route = FAVORITE_ROUTE,
    ) {
        FavoriteRoute()
    }
}

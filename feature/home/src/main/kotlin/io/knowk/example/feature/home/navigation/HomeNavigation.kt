package io.knowk.example.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.knowk.example.feature.home.ui.HomeRoute

const val HOME_ROUTE = "homeRoute"

fun NavController.navigateHome() {
    navigate(HOME_ROUTE) {
        restoreState = true
        launchSingleTop = true
        popUpTo(HOME_ROUTE)
    }
}

fun NavGraphBuilder.homeScreen() {
    composable(
        route = HOME_ROUTE,
    ) {
        HomeRoute()
    }
}

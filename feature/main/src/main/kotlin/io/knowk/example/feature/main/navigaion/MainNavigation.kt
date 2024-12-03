package io.knowk.example.feature.main.navigaion

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.knowk.example.feature.main.ui.MainRoute

const val MAIN_ROUTE = "mainRoute"

fun NavGraphBuilder.mainScreen() {
    composable(
        route = MAIN_ROUTE,
    ) {
        MainRoute(
            navHostController = rememberNavController(),
        )
    }
}

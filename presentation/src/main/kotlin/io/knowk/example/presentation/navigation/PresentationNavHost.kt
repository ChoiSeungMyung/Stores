package io.knowk.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import io.knowk.example.feature.main.navigaion.MAIN_ROUTE
import io.knowk.example.feature.main.navigaion.mainScreen

@Composable
internal fun PresentationNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = MAIN_ROUTE,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        mainScreen()
    }
}

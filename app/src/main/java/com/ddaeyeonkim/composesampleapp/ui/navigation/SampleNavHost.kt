package com.ddaeyeonkim.composesampleapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ddaeyeonkim.composesampleapp.ui.screen.Home

@Composable
fun SampleNavHost(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.Home.route
    ) {
        sampleNavigation()
    }
}

fun NavGraphBuilder.sampleNavigation() {
    composable(route = Screens.Home.name) {
        Home()
    }
}
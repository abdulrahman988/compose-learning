package com.example.composelearning.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composelearning.screens.GymDetailsScreen
import com.example.composelearning.screens.GymsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Gyms.route) {
        composable(route = Screens.Gyms.route) {
            GymsScreen(navController)
        }
        composable(
            route = Screens.GymsDetails.route,
            arguments = listOf(navArgument("gymId") { type = NavType.IntType })
        ) { backStackEntry ->
            val gymId = backStackEntry.arguments?.getInt("gymId")
            requireNotNull(gymId)
            GymDetailsScreen(navController, gymId)
        }
    }
}
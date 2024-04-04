package com.example.composelearning.navigation

sealed class Screens(val route: String) {
    object Gyms: Screens("gyms")
    object GymsDetails: Screens("{gymId}/gymsDetails"){
        fun createRoute(gymId: Int) = "$gymId/gymsDetails"
    }
}
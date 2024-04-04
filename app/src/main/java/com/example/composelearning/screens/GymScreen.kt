package com.example.composelearning.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composelearning.composable.GymItemCard
import com.example.composelearning.navigation.Screens
import com.example.composelearning.viewmodel.GymsViewModel

@Composable
fun GymsScreen(navController: NavController) {
    val viewmodel: GymsViewModel = viewModel()
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(viewmodel.state) { gym ->
            GymItemCard(
                gym = gym,
                onClickOnCard = { navController.navigate(Screens.GymsDetails.createRoute(gym.id)) },
                onClickOnFavorite = { viewmodel.toggleFavouriteState(it) })
        }
    }
}
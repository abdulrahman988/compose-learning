package com.example.composelearning.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composelearning.composable.FavouriteIcon
import com.example.composelearning.composable.GymDetails
import com.example.composelearning.composable.GymItemCard
import com.example.composelearning.composable.PlaceIcon
import com.example.composelearning.viewmodel.GymsDetailsViewModel
import com.example.composelearning.viewmodel.GymsViewModel


@Composable
fun GymDetailsScreen(navController: NavController, gymId: Int) {
    val viewmodel: GymsDetailsViewModel = viewModel()
    val item = viewmodel.state.value
    viewmodel.getGym(gymId)

    item?.let {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PlaceIcon(
                icon = Icons.Filled.Place, modifier = Modifier.padding(bottom = 32.dp, top = 32.dp)
            )
            GymDetails(
                item = it,
                modifier = Modifier.padding(bottom = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            Text(
                text = if (it.isOpen) "Gym is open" else "Gym is closed",
                color = if (it.isOpen) Color.Green else Color.Red
            )

        }
    }
}
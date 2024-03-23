package com.example.composelearning.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composelearning.composable.GymItemCard
import com.example.composelearning.viewmodel.GymsViewModel

@Composable
fun GymsLazyColumn() {
    val viewmodel: GymsViewModel = viewModel()
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(viewmodel.state) { gym ->
            GymItemCard(gym = gym) { it ->
                viewmodel.toggleFavouriteState(it)
            }
        }
    }
}
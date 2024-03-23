package com.example.composelearning.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composelearning.GymItemCard
import com.example.composelearning.GymsViewModel
import com.example.composelearning.gymList

@Composable
fun GymsLazyColumn() {
    val viewmodel: GymsViewModel = viewModel()

    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(viewmodel.state.value) { gym ->
            GymItemCard(gym = gym) { it ->
                viewmodel.toggleFavouriteState(it)
            }
        }
    }
}
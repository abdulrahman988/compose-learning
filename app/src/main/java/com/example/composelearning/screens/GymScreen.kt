package com.example.composelearning.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composelearning.GymItemCard
import com.example.composelearning.gymList

@Composable
fun GymsLazyColumn(){
    LazyColumn(modifier = Modifier.fillMaxHeight()){
        items(gymList){ gym ->
            GymItemCard(gym = gym)
        }
    }
}
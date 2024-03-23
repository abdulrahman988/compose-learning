package com.example.composelearning.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composelearning.db.model.Gym
import com.example.composelearning.R

@Composable
fun GymItemCard(gym: Gym, onClick: (Int) -> Unit) {
    val isFavouriteState by remember { mutableStateOf(false) }
    val icon = if (gym.isOpen){
        Icons.Filled.Favorite
    }else{
        Icons.Filled.FavoriteBorder
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            GymIcon(modifier = Modifier.weight(15f))
            GymDetails(gym,modifier = Modifier.weight(70f))
            FavouriteIcon(icon,modifier = Modifier.weight(15f)) {
                onClick(gym.id)
            }
        }
    }
}

@Composable
fun GymIcon(modifier: Modifier){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun GymDetails(item: Gym, modifier: Modifier){
    Column(modifier = modifier) {
        Text(
            text = item.gymName,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = item.gymLocation,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}
@Composable
fun FavouriteIcon(icon: ImageVector,modifier: Modifier, onClick: () -> Unit){
    Image(
        imageVector = icon,
        contentDescription = null,
        modifier = modifier.padding(8.dp)
            .clickable { onClick() },
        contentScale = ContentScale.Inside
    )
}
package com.example.composelearning

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun GymItemCard(gym: Gym) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .weight(15f),
                contentScale = ContentScale.Crop
            )

//            Spacer(modifier = Modifier.height(8.dp))
            Column(modifier = Modifier.weight(70f)) {
                Text(
                    text = gym.name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = gym.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

            }
            Image(
                imageVector = Icons.Filled.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .weight(15f),
                contentScale = ContentScale.Inside
            )

//            Text(
//                text = "ID: ${gym.id}",
//                style = MaterialTheme.typography.bodySmall,
//                color = Color.Gray,
//                modifier = Modifier.weight(15f)
//            )

            // Add any additional UI elements you want here

        }
    }
}
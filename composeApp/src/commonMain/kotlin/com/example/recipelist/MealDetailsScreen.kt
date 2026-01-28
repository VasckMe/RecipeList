package com.example.recipelist

import viewModel.MealDetailsViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun MealDetailsScreen(
    dishId: String,
    viewModel: MealDetailsViewModel = viewModel()
) {
    LaunchedEffect(dishId) {
        viewModel.fetchDetails(dishId)
    }

    val details by viewModel.detailsModel.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        val currentDetails = details
        if (currentDetails == null) {
            CircularProgressIndicator()
        } else {
            AsyncImage(
                model = currentDetails.thumbnailString,
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Fit
            )

            Text(
                text = currentDetails.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = currentDetails.category,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = currentDetails.instructions,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
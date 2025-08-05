package com.examplesearch.ui.screens.recipe_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreen(modifier: Modifier = Modifier, viewModel: RecipeDetailsViewModel) {
    val uiState = viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = uiState.value.data?.strMeal.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            })
        },
        content = {
            if (uiState.value.isLoading) {
                Box(
                    modifier = Modifier.padding(it).fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    )
}



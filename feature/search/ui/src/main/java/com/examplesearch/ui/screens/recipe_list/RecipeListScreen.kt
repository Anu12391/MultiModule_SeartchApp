package com.examplesearch.ui.screens.recipe_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.common.utils.UiText

@Composable
fun RecipeListScreen(modifier: Modifier = Modifier, viewModel: RecipeListViewModel) {
    val uiState = viewModel.uiState.collectAsState()
    val query = rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TextField(
                value = query.value,
                onValueChange = {
                    query.value = it
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedTextColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) {

        if (uiState.value.isLoading) {
            Box(
                modifier = Modifier.padding(it).fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        if (uiState.value.error != UiText.Idle) {
            Box(
                modifier = Modifier.padding(it).fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = uiState.value.error.getString(context))
            }
        }

    }


}
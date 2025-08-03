package com.examplesearch.ui.screens.recipe_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.common.utils.UiText

@Composable
fun RecipeListScreen(modifier: Modifier = Modifier, viewModel: RecipeListViewModel) {
    val uiState = viewModel.uiState.collectAsState()
    val query = rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(topBar = {
        TextField(
            value = query.value, onValueChange = {
                query.value = it
            }, colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedTextColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ), modifier = Modifier.fillMaxWidth()
        )
    }) {

        if (uiState.value.isLoading) {
            Box(
                modifier = Modifier.padding(it).fillMaxSize(), contentAlignment = Center
            ) {
                CircularProgressIndicator()
            }
        }
        if (uiState.value.error != UiText.Idle) {
            Box(
                modifier = Modifier.padding(it).fillMaxSize(), contentAlignment = Center
            ) {
                Text(text = uiState.value.error.getString(context))
            }
        }
        uiState.value.data?.let { list ->
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                items(list) { item ->
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        AsyncImage(
                            model = item,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = item.strMeal.toString(),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        if (item.strTags.toString().isNotEmpty()){
                            FlowRow {  }
                        }
                    }
                }
            }
        }
    }


}
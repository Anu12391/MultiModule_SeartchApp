package com.examplesearch.ui.screens.recipe_list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.common.navigation.NavigationRoutes
import com.example.common.utils.UiText
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RecipeListScreen(
    modifier: Modifier = Modifier,
    viewModel: RecipeListViewModel,
    onClick: (String) -> Unit,
    navHostController:NavHostController
) {
    val uiState = viewModel.uiState.collectAsState()
    val query = rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(key1 = viewModel.navigation) {
        viewModel.navigation.flowWithLifecycle(lifecycleOwner.lifecycle).collectLatest {
            when (it) {
                is RecipeList.Navigation.GotoRecipeDetails -> {
                    navHostController.navigate(NavigationRoutes.RecipeDetails.sendId(it.id))
                }
            }
        }

    }

    Scaffold(topBar = {
        TextField(
            placeholder = { Text("Search Here.....", style = MaterialTheme.typography.bodyMedium) },
            value = query.value, onValueChange = {
                query.value = it
                viewModel.onEvent(RecipeList.Event.SearchRecipe(query.value))
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
                            .padding(horizontal = 12.dp, vertical = 4.dp).clickable {
                                onClick.invoke(item.idMeal ?: "-1")
                            },
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
                        Column(
                            modifier = Modifier.padding(12.dp).fillMaxWidth()
                                .padding(horizontal = 12.dp)
                        ) {

                        }



                        Text(
                            text = item.strMeal.toString(),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = item.strInstructions.toString(),
                            style = MaterialTheme.typography.bodyMedium,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 4
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        if (item.strTags.toString().isNotEmpty()) {
                            FlowRow {
                                item.strTags?.split(",")?.forEach {
                                    Box(
                                        modifier = Modifier.wrapContentSize()
                                            .padding(horizontal = 8.dp, vertical = 4.dp)
                                            .background(
                                                color = Color.White,
                                                shape = RoundedCornerShape(24.dp)
                                            ).clip(RoundedCornerShape(12.dp))
                                            .border(
                                                width = 1.dp,
                                                color = Color.Red,
                                                shape = RoundedCornerShape(12.dp)
                                            ),

                                        contentAlignment = Center
                                    ) {
                                        Text(
                                            text = it,
                                            style = MaterialTheme.typography.bodySmall,
                                            modifier = Modifier.padding(
                                                horizontal = 8.dp,
                                                vertical = 8.dp
                                            )
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                }
            }
        }
    }


}
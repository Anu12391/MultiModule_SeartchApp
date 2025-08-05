package com.examplesearch.ui.screens.recipe_details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import coil.compose.AsyncImage
import com.example.common.utils.UiText
import com.example.search.domain.model.RecipesDetails
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: RecipeDetailsViewModel,
    onNavigationClick: () -> Unit,
    onDeleteClick: (RecipesDetails) -> Unit,
    onFavouriteClick: (RecipesDetails) -> Unit,
) {
    val uiState = viewModel.uiState.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    LaunchedEffect(key1 = viewModel.navigation) {
        viewModel.navigation.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collectLatest { navigation ->
                when (navigation) {
                    RecipeDetailsViewModel.RecipeDetails.Navigation.GoToRecipeListScreen -> {
                        
                    }
                }

            }

    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = uiState.value.data?.strMeal.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }, navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            onNavigationClick.invoke()
                        })
                }
            }, actions = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = null)
                }
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                }
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
            if (uiState.value.error != UiText.Idle) {
                Box(
                    modifier = Modifier.padding(it).fillMaxSize(), contentAlignment = Center
                ) {
                    Text(text = uiState.value.error.getString(context))
                }
            }

            uiState.value.data?.let {
                Column(
                    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
                        .padding(8.dp)
                ) {
                    AsyncImage(
                        model = it.strMealThumb,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )

                }
                Spacer(modifier = Modifier.height(12.dp))
                it.ingredientPair?.forEach {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = getIngredientsUrl(it.first),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.background(color = Color.White, shape = CircleShape)
                                .size(60.dp)
                                .clip(
                                    CircleShape
                                )


                        )
                        Text(
                            text = it.second,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Watch Youtube Videos",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                }

            }

        }
    )
}

fun getIngredientsUrl(name: String) {
    "https://www.themealdb.com/images/ingedients/${name}.png"
}



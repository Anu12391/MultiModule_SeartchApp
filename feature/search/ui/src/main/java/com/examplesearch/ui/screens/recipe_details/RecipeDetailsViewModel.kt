package com.examplesearch.ui.screens.recipe_details

import androidx.lifecycle.ViewModel
import com.example.common.utils.NetworkResult
import com.example.common.utils.UiText
import com.example.search.data.use_cases.GetRecipeDetailsUseCases
import com.example.search.domain.model.RecipesDetails

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(private val getRecipeDetailsUseCases: GetRecipeDetailsUseCases) :
    ViewModel() {

    private val _uiState = MutableStateFlow(RecipeDetails.UiState())
    val uiState: StateFlow<RecipeDetails.UiState> get() = _uiState.asStateFlow()

fun recipeDetails(id:String)=getRecipeDetailsUseCases.invoke(id).onEach {
    result->
    when(result){
        is NetworkResult.Error -> TODO()
        is NetworkResult.Loading -> TODO()
        is NetworkResult.Success -> TODO()
    }

}

    object RecipeDetails {
        data class UiState(
            val isLoading: Boolean = false,
            val error: UiText = UiText.Idle,
            val data: List<RecipesDetails>? = null,
        )

        sealed interface Navigation {


        }

        sealed interface Event {


        }
    }
}
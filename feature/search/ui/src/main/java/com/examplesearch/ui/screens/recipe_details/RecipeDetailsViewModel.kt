package com.examplesearch.ui.screens.recipe_details

import androidx.lifecycle.ViewModel
import com.example.common.utils.UiText
import com.example.search.data.use_cases.GetRecipeDetailsUseCases
import com.example.search.domain.model.RecipesDetails
import com.examplesearch.ui.screens.recipe_list.RecipeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(private val getRecipeDetailsUseCases: GetRecipeDetailsUseCases) :
    ViewModel() {

    private val _uiState = MutableStateFlow(RecipeList.UiState())
    val uiState: StateFlow<RecipeList.UiState> get() = _uiState.asStateFlow()



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
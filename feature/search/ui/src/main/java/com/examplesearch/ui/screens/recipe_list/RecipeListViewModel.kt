package com.examplesearch.ui.screens.recipe_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.utils.NetworkResult
import com.example.common.utils.UiText
import com.example.search.data.use_cases.GetAllRecipesUseCases
import com.example.search.domain.model.Recipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(private val getAllRecipesUseCases: GetAllRecipesUseCases) :
    ViewModel() {
    private val _uiState = MutableStateFlow(RecipeList.UiState())
    val uiState: StateFlow<RecipeList.UiState> get() = _uiState.asStateFlow()
    fun search(q: String) = viewModelScope.launch {
        getAllRecipesUseCases.invoke(q).onEach { result ->

            when (result) {
                is NetworkResult.Loading -> {
                    _uiState.update {
                        RecipeList.UiState(isLoading = true)
                    }

                }

                is NetworkResult.Error -> _uiState.update {
                    RecipeList.UiState(error = UiText.RemoteString(result.message.toString()))
                }

                is NetworkResult.Success -> _uiState.update {
                    RecipeList.UiState(data = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }


}


object RecipeList {
    data class UiState(
        val isLoading: Boolean = false,
        val error: UiText = UiText.Idle,
        val data: List<Recipes>? = null,
    )

    sealed interface Navigation {
        data class GotoRecipeDetails(val id: String) : Navigation

    }

    sealed interface Event {

    }
}
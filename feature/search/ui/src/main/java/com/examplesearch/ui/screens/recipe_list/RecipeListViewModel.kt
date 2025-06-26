package com.examplesearch.ui.screens.recipe_list

import com.example.search.data.use_cases.GetAllRecipesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(private val getAllRecipesUseCases: GetAllRecipesUseCases) {
}
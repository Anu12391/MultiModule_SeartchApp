package com.example.search.domain.repository

import com.example.search.domain.model.Recipes
import com.example.search.domain.model.RecipesDetails

interface SearchRepository {
    suspend fun getRecipes(s:String): List<Recipes>
    suspend fun getRecipeDetails(id:String): List<RecipesDetails>
}
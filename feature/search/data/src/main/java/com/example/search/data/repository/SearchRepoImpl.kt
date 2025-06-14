package com.example.search.data.repository

import com.example.search.domain.model.Recipes
import com.example.search.domain.model.RecipesDetails
import com.example.search.domain.repository.SearchRepository

class SearchRepoImpl: SearchRepository {
    override suspend fun getRecipes(): List<Recipes> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipeDetails(id: String): List<RecipesDetails> {
        TODO("Not yet implemented")
    }
}
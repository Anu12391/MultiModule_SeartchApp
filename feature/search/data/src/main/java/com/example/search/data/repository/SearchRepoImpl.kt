package com.example.search.data.repository

import com.example.search.data.remote.SearchApiService
import com.example.search.domain.model.Recipes
import com.example.search.domain.model.RecipesDetails
import com.example.search.domain.repository.SearchRepository

class SearchRepoImpl(val searchApiService: SearchApiService) : SearchRepository {
    override suspend fun getRecipes(s: String): List<Recipes> {
        searchApiService.getRecipes(s)
    }

    override suspend fun getRecipeDetails(id: String): List<RecipesDetails> {
        TODO("Not yet implemented")
    }
}
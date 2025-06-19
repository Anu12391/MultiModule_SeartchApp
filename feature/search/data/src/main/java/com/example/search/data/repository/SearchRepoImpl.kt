package com.example.search.data.repository

import com.example.search.data.mappers.toDomain
import com.example.search.data.remote.SearchApiService
import com.example.search.domain.model.Recipes
import com.example.search.domain.model.RecipesDetails
import com.example.search.domain.repository.SearchRepository

class SearchRepoImpl(val searchApiService: SearchApiService) : SearchRepository {
    override suspend fun getRecipes(s: String): Result<List<Recipes>> {
        val response = searchApiService.getRecipes(s)
        return if (response.isSuccessful) {
            response.body()?.meals?.let {
                Result.success(it.toDomain())
            } ?: run {
                Result.failure(Exception("error occured"))
            }

        } else {
            Result.failure(Exception("error occured"))
        }

    }

    override suspend fun getRecipeDetails(id: String): Result<RecipesDetails> {
        val response = searchApiService.getRecipeDetails(id)
        return if (response.isSuccessful) {
            response.body()?.meals?.let {
                if (it.isNotEmpty()) {

                    Result.success(it.first().toDomain())
                } else {
                    Result.failure(Exception("error occured"))

                }

            } ?: run { Result.failure(Exception("error occured")) }
        } else {
            Result.failure(Exception("error occured"))
        }
    }
}
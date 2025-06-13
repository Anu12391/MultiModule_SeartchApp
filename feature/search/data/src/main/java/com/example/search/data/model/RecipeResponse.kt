package com.example.search.data.model

import com.google.gson.annotations.SerializedName

data class RecipeResponse(

	@field:SerializedName("meals")
	val meals: List<RecipesDTO>? = null
)

data class RecipeDetailResponse(

	@field:SerializedName("meals")
	val meals: List<RecipesDTO>? = null
)



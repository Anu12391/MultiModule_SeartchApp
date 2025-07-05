package com.example.common.navigation

sealed class NavigationRoutes(val routes:String) {
data object RecipeList:NavigationRoutes("/recipe_list")
data object RecipeDetails:NavigationRoutes("/recipe_details/{id}"){
    fun sendId(id:String)="/recipe_details/${id}"
}
}
sealed class NavigationSubGraphRoutes(val routes:String) {
    data object Search:NavigationSubGraphRoutes("/search")
}
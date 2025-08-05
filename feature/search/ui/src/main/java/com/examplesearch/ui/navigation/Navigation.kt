package com.examplesearch.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.common.navigation.FeatureApi
import com.example.common.navigation.NavigationRoutes
import com.example.common.navigation.NavigationSubGraphRoutes
import com.examplesearch.ui.screens.recipe_details.RecipeDetailsScreen
import com.examplesearch.ui.screens.recipe_details.RecipeDetailsViewModel
import com.examplesearch.ui.screens.recipe_details.RecipeDetailsViewModel.RecipeDetails.Event.FetchRecipeDetails
import com.examplesearch.ui.screens.recipe_list.RecipeList
import com.examplesearch.ui.screens.recipe_list.RecipeListScreen
import com.examplesearch.ui.screens.recipe_list.RecipeListViewModel

interface SearchFeatureApi : FeatureApi {}

class SearchFeatureApiImpl : SearchFeatureApi {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController
    ) {
        navGraphBuilder.navigation(
            route = NavigationSubGraphRoutes.Search.routes,
            startDestination = NavigationRoutes.RecipeList.routes
        ) {
            composable(route = NavigationRoutes.RecipeList.routes) {
                val viewModel = hiltViewModel<RecipeListViewModel>()
                RecipeListScreen(
                    viewModel = viewModel,

                    onClick = { mealId ->
                        viewModel.onEvent(RecipeList.Event.GoToRecipeDetails(mealId))
                    },
                    navHostController = navHostController
                )

            }

            composable(route = NavigationRoutes.RecipeDetails.routes) {
                val viewModel = hiltViewModel<RecipeDetailsViewModel>()
                val mealId=it.arguments?.getString("id")
                mealId?.let {
                    viewModel.onEvent(FetchRecipeDetails){

                    }
                }
                RecipeDetailsScreen(viewModel = viewModel)

            }
        }
    }

}
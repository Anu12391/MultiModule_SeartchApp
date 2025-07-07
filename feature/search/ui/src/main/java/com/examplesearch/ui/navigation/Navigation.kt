package com.examplesearch.ui.navigation

import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.common.navigation.FeatureApi
import com.example.common.navigation.NavigationRoutes
import com.example.common.navigation.NavigationSubGraphRoutes

interface SearchFeatureApi : FeatureApi

class SearchFeatureApiImpl : SearchFeatureApi {
    override fun registerGraph(
        navGraphBuilder: androidx.navigation.NavGraphBuilder,
        navHostController: androidx.navigation.NavHostController
    ) {
        navGraphBuilder.navigation(
            route = NavigationSubGraphRoutes.Search.routes,
            startDestination = NavigationRoutes.RecipeList.routes
        ) {
            composable(route = NavigationRoutes.RecipeList.routes) {
            }
        }
    }

}
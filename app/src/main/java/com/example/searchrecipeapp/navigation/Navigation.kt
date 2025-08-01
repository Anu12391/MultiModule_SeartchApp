package com.example.searchrecipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.common.navigation.NavigationSubGraphRoutes

@Composable
fun RecipeNavigation(modifier: Modifier = Modifier, navigationSubgraph: NavigationSubgraph) {
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = NavigationSubGraphRoutes.Search.routes
    ) {
        navigationSubgraph.searchFeatureApi.registerGraph(
            navHostController = navHostController,
            navGraphBuilder = this
        )
    }

}
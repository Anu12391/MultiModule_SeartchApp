package com.examplesearch.ui.navigation

import com.example.common.navigation.FeatureApi

interface SearchFeatureApi: FeatureApi

class SearchFeatureApiImpl:SearchFeatureApi{
    override fun registerGraph(
        navGraphBuilder: androidx.navigation.NavGraphBuilder,
        navHostController: androidx.navigation.NavHostController
    ) {

    }

}
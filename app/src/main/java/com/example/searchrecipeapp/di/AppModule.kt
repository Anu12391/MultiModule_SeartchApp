package com.example.searchrecipeapp.di

import com.example.searchrecipeapp.navigation.NavigationSubgraph
import com.examplesearch.ui.navigation.SearchFeatureApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideNavigationSubgraph(searchFeautureApi: SearchFeatureApi): NavigationSubgraph {
        return NavigationSubgraph(searchFeautureApi)
    }


}
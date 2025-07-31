package com.example.di

import com.examplesearch.ui.navigation.SearchFeatureApi
import com.examplesearch.ui.navigation.SearchFeatureApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun providesSearchFeaturesAPI():SearchFeatureApiImpl{
        return SearchFeatureApiImpl()
    }

}
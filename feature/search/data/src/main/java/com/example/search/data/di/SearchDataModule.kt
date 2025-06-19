package com.example.search.data.di

import com.example.search.data.remote.SearchApiService
import com.example.search.data.repository.SearchRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@InstallIn(ActivityComponent::class)
@Module
object SearchDataModule {
    @Provides
    fun provideSearchAPIService(retrofit: Retrofit): SearchApiService {
        return retrofit.create(SearchApiService::class.java)
    }

    @Provides
    fun provideSearchRepository(searchApiService: SearchApiService): SearchRepoImpl {
        return SearchRepoImpl(searchApiService)
    }
}
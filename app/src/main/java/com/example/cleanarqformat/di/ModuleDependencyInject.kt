package com.example.cleanarqformat.di

import com.example.cleanarqformat.data.SearchRepositoryImplementation
import com.example.cleanarqformat.data.Services
import com.example.cleanarqformat.domain.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleDependencyInject {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.mercadolibre.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): Services{
        return retrofit.create(Services::class.java)
    }

    @Provides
    @Singleton
    fun provideSearchRepository(services: Services): SearchRepository{
        return SearchRepositoryImplementation(services)
    }
}
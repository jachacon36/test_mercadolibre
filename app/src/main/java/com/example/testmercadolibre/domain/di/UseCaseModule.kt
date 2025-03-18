package com.example.testmercadolibre.domain.di

import com.example.testmercadolibre.domain.usecase.GetSearchUseCase
import com.example.testmercadolibre.domain.usecase.GetProductDetailsUseCase
import com.example.testmercadolibre.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun getSearchUseCaseProvider(repositoryImpl: RepositoryImpl): GetSearchUseCase {
        return GetSearchUseCase(repositoryImpl)
    }

    @Provides
    @Singleton
    fun getProductDetailsUseCaseProvider(repositoryImpl: RepositoryImpl): GetProductDetailsUseCase {
        return GetProductDetailsUseCase(repositoryImpl)
    }

}
package com.example.testmercadolibre.data.di

import android.content.Context
import com.example.testmercadolibre.data.network.ApiService
import com.example.testmercadolibre.data.network.LocalService
import com.example.testmercadolibre.data.repository.RepositoryImpl
import com.example.testmercadolibre.domain.repository.Repository
import com.example.testmercadolibre.utils.AuthInterceptor
import com.example.testmercadolibre.utils.Constant.BASE_URL
import com.example.testmercadolibre.utils.TimberLoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Provider
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptorProvider: Provider<AuthInterceptor>): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor(TimberLoggingInterceptor())
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptorProvider.get())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providerApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providerRepositoryImpl(apiService: ApiService, localService: LocalService): Repository {
        return RepositoryImpl(apiService, localService)
    }

    @Provides
    @Singleton
    fun providerAuthInterceptor(apiServiceProvider: Provider<ApiService>): AuthInterceptor {
        return AuthInterceptor(apiServiceProvider)
    }

    @Provides
    @Singleton
    fun providerLocalService(@ApplicationContext context: Context): LocalService {
        return LocalService(context)
    }
}
package com.action.bottomnavigation.di

import com.action.bottomnavigation.data.ApiDetails
import com.action.bottomnavigation.data.ApiReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    // GSON Converter
    @Provides
    fun provideConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    // Retrofit
    @Provides
    fun provideRetrofit(
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiReference.BASE_URL)
            .addConverterFactory(converterFactory)
            .build()
    }

    // API client
    @Provides
    fun provideApiClient(
        retrofit: Retrofit
    ): ApiDetails {
        return retrofit.create(ApiDetails::class.java)
    }


}
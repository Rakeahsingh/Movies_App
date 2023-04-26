package com.example.rkmovies.di


import com.example.rkmovies.api.ApiService
import com.example.rkmovies.helper.constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URl: String): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}
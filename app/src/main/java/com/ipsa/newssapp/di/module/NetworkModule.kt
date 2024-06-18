package com.ipsa.newssapp.di.module

import com.ipsa.newssapp.BuildConfig
import com.ipsa.newssapp.data.api.HeaderInterceptor
import com.ipsa.newssapp.data.api.NetworkService
import com.ipsa.newssapp.data.util.Const
import com.ipsa.newssapp.di.ApiKey
import com.ipsa.newssapp.di.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @ApiKey
    @Provides
    fun provideApiKey(): String = BuildConfig.API_KEY

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = Const.BASE_URL

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideNetworkService(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): NetworkService {
        return Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
            .addConverterFactory(gsonConverterFactory).build().create(NetworkService::class.java)
    }

    @Singleton
    @Provides
    fun provideHttpClient(headerInterceptor: HeaderInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(headerInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideHeaderInterceptor(@ApiKey apiKey: String): HeaderInterceptor {
        return HeaderInterceptor(apiKey)
    }

}
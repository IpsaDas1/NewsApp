package com.ipsa.newssapp.di.module

import com.ipsa.newssapp.data.util.ConnectivityManager
import com.ipsa.newssapp.data.util.ConnectivityManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationModule {
    /* @Provides
     fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager{
         return ConnectivityManagerImpl(context)
     }*/
    @Binds
    abstract fun bindConnectivityManager(
        connectivityManagerImpl: ConnectivityManagerImpl
    ): ConnectivityManager
}
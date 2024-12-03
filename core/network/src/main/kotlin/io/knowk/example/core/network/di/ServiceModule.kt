package io.knowk.example.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import io.knowk.example.core.network.service.StoreService

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideStoreService(
        retrofit: Retrofit,
    ): StoreService {
        return retrofit.create(StoreService::class.java)
    }
}

package io.knowk.example.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.knowk.example.core.data.repository.StoreRepository
import io.knowk.example.core.data.repository.impl.StoreRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindStoreRepository(
        impl: StoreRepositoryImpl,
    ): StoreRepository
}

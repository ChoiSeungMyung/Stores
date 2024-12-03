package io.knowk.example.core.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.knowk.example.core.network.source.StoreRemoteSource
import io.knowk.example.core.network.source.impl.StoreRemoteSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteSourceModule {

    @Binds
    @Singleton
    abstract fun bindStoreRemoteSource(
        impl: StoreRemoteSourceImpl,
    ): StoreRemoteSource
}

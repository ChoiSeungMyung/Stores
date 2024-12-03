package io.knowk.example.core.database.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.knowk.example.core.database.source.FavoriteStoresLocalSource
import io.knowk.example.core.database.source.impl.FavoriteStoresLocalSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {

    @Binds
    abstract fun bindFavoriteStoresLocalSource(
        impl: FavoriteStoresLocalSourceImpl,
    ): FavoriteStoresLocalSource
}

package io.knowk.example.core.logger.di

import io.knowk.example.core.logger.TimberTree
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.knowk.example.core.contract.ServiceName
import javax.inject.Singleton
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
object LoggerModule {
    @Provides
    @Singleton
    fun provideTimberTree(
        @ServiceName serviceName: String,
    ): Timber.Tree = TimberTree(serviceName)
}

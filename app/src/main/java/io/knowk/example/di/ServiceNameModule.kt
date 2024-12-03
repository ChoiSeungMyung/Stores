package io.knowk.example.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.knowk.example.R
import io.knowk.example.core.contract.ServiceName

@Module
@InstallIn(SingletonComponent::class)
object ServiceNameModule {
    @ServiceName
    @Provides
    fun provideServiceName(
        @ApplicationContext context: Context,
    ): String = context.getString(R.string.app_name)
}

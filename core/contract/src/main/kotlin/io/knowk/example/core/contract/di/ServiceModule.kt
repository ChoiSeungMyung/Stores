package io.knowk.example.core.contract.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.knowk.example.contract.R
import io.knowk.example.core.contract.BaseUrl
import io.knowk.example.core.contract.policy.ServicePolicy

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun provideServicePolicy(
        @ApplicationContext context: Context,
    ): ServicePolicy =
        ServicePolicy(
            writeTimeout = context.resources.getInteger(R.integer.write_timeout),
            readTimeout = context.resources.getInteger(R.integer.read_timeout),
            connectTimeout = context.resources.getInteger(R.integer.connect_timeout),
        )

    @BaseUrl
    @Provides
    fun provideBaseUrl(
        @ApplicationContext context: Context,
    ): String = context.getString(R.string.base_url)
}

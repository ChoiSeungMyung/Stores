package io.knowk.example.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.knowk.example.core.contract.BaseUrl
import io.knowk.example.core.contract.ConnectTimeout
import io.knowk.example.core.contract.ReadTimeout
import io.knowk.example.core.contract.WriteTimeout
import io.knowk.example.core.contract.policy.ServicePolicy
import io.knowk.example.core.network.interceptor.HeaderInterceptor
import io.knowk.example.core.network.interceptor.LoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @WriteTimeout
    @Provides
    fun provideWriteTimeout(
        servicePolicy: ServicePolicy,
    ): Long = servicePolicy.writeTimeout.toLong()

    @ReadTimeout
    @Provides
    fun provideReadTimeout(
        servicePolicy: ServicePolicy,
    ): Long = servicePolicy.readTimeout.toLong()

    @ConnectTimeout
    @Provides
    fun provideConnectTimeout(
        servicePolicy: ServicePolicy,
    ): Long = servicePolicy.connectTimeout.toLong()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @WriteTimeout writeTimeout: Long,
        @ReadTimeout readTimeout: Long,
        @ConnectTimeout connectTimeout: Long,
        @HeaderInterceptor headerInterceptor: Interceptor,
        @LoggingInterceptor loggingInterceptor: Interceptor,
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .writeTimeout(writeTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        @BaseUrl baseUrl: String,
        okHttpClient: OkHttpClient,
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }
}

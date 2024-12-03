package io.knowk.example.core.contract

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class WriteTimeout

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ReadTimeout

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ConnectTimeout

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class BaseUrl

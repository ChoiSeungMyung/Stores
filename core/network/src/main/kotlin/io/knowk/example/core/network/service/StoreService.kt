package io.knowk.example.core.network.service

import io.knowk.example.core.network.response.FetchStoresResponse
import retrofit2.http.GET

interface StoreService {

    @GET("/stores")
    suspend fun fetchStores(): FetchStoresResponse
}

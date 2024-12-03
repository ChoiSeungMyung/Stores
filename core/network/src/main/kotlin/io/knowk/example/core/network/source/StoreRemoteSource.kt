package io.knowk.example.core.network.source

import io.knowk.example.core.network.response.FetchStoresResponse

interface StoreRemoteSource {

    suspend fun fetchStores(): FetchStoresResponse
}

package io.knowk.example.core.network.source.impl

import io.knowk.example.core.network.response.FetchStoresResponse
import io.knowk.example.core.network.service.StoreService
import io.knowk.example.core.network.source.StoreRemoteSource
import javax.inject.Inject

class StoreRemoteSourceImpl @Inject constructor(
    private val service: StoreService,
) : StoreRemoteSource {

    override suspend fun fetchStores(): FetchStoresResponse {
        return service.fetchStores()
    }
}

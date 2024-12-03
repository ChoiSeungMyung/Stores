package io.knowk.example.core.network.response

import kotlinx.serialization.Serializable

@Serializable
data class FetchStoresResponse(
    val title: String,
    val list: List<StoreResponse>,
)

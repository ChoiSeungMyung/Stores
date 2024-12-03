package io.knowk.example.core.network.response

import kotlinx.serialization.Serializable

@Serializable
data class StoreResponse(
    val code: String,
    val thumbnailUrl: String,
    val iconImageUrl: String,
    val name: String = "",
)

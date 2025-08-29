package com.ifound.data.network.dataSource.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class SignInResponse(
    val token: String
)
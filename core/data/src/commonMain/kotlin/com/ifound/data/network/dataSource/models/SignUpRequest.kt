package com.ifound.data.network.dataSource.models

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val name: String,
    val email: String,
    val password: String,
    val passwordConfirmation: String,
    val address: CreateAddressRequest? = null
)

package com.ifound.data.network.dataSource.models.requests

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
@Serializable
data class CreateAddressRequest(
    val userId: Uuid,
    val street: String,
    val number: Int,
    val neighborhood: String,
    val complement: String?,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String
)
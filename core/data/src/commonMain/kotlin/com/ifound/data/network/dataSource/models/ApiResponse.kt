package com.ifound.data.network.dataSource.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val code: Int,
    val data: T,
)

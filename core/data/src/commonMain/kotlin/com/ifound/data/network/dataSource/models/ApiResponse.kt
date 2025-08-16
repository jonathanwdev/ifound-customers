package com.ifound.data.network.dataSource.models

data class ApiResponse<T>(
    val code: Int,
    val data: T,
)

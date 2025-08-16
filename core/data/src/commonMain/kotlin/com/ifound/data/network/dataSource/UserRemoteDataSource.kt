package com.ifound.data.network.dataSource

import com.ifound.data.network.dataSource.models.ApiResponse
import com.ifound.data.network.dataSource.models.SignUpRequest


interface UserRemoteDataSource {
    suspend fun signUp(request: SignUpRequest): ApiResponse<String>
}
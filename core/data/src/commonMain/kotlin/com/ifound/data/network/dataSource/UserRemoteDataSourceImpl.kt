package com.ifound.data.network.dataSource

import com.ifound.data.network.dataSource.models.ApiResponse
import com.ifound.data.network.dataSource.models.SignUpRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class UserRemoteDataSourceImpl(
    private val httpClient: HttpClient
): UserRemoteDataSource {
    override suspend fun signUp(request: SignUpRequest): ApiResponse<String> {
        return  httpClient.post("customer/v1/create") {
            setBody(request)
        }.body()
    }

}
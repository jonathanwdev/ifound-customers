package com.ifound.data.network.dataSource

import com.ifound.data.network.dataSource.models.ApiResponse
import com.ifound.data.network.dataSource.models.requests.ForgotPasswordRequest
import com.ifound.data.network.dataSource.models.requests.ResetPasswordRequest
import com.ifound.data.network.dataSource.models.requests.SignInRequest
import com.ifound.data.network.dataSource.models.requests.SignUpRequest
import com.ifound.data.network.dataSource.models.requests.ValidateTokenRequest
import com.ifound.data.network.dataSource.models.responses.SignInResponse
import com.ifound.data.network.dataSource.models.responses.ValidateTokenResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody


interface AuthRemoteDataSource {
    suspend fun signUp(request: SignUpRequest): ApiResponse<String>
    suspend fun signIn(request: SignInRequest): ApiResponse<SignInResponse>
    suspend fun forgotPassword(request: ForgotPasswordRequest): ApiResponse<String>
    suspend fun validateTokenPassword(request: ValidateTokenRequest): ApiResponse<ValidateTokenResponse>
    suspend fun resetPassword(request: ResetPasswordRequest): ApiResponse<String>
}


class AuthRemoteDataSourceImpl(
    private val httpClient: HttpClient
): AuthRemoteDataSource {
    override suspend fun signUp(request: SignUpRequest): ApiResponse<String> {
        return  httpClient.post("auth/v1/sign-up-customer") {
            setBody(request)
        }.body()
    }

    override suspend fun signIn(request: SignInRequest): ApiResponse<SignInResponse> {
        return  httpClient.post("auth/v1/sign-in") {
            setBody(request)
        }.body<ApiResponse<SignInResponse>>()
    }

    override suspend fun forgotPassword(request: ForgotPasswordRequest): ApiResponse<String> {
        return  httpClient.post("auth/v1/forgot-password") {
            setBody(request)
        }.body()
    }

    override suspend fun validateTokenPassword(request: ValidateTokenRequest): ApiResponse<ValidateTokenResponse> {
        return  httpClient.post("auth/v1/validate-password-token") {
            setBody(request)
        }.body()
    }

    override suspend fun resetPassword(request: ResetPasswordRequest): ApiResponse<String> {
        return  httpClient.post("auth/v1/reset-password") {
            setBody(request)
        }.body()
    }


}
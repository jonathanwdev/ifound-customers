package com.ifound.data.network.repository

import com.ifound.data.network.dataSource.UserRemoteDataSource
import com.ifound.data.network.dataSource.models.SignUpRequest
import com.ifound.domain.models.RegisterCustomer
import com.ifound.domain.repository.AuthRepository
import kotlinx.coroutines.delay




class AuthRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource
) : AuthRepository {
    override suspend fun signUp(request: RegisterCustomer): Result<String> {
        return runCatching {
            delay(2000)
            val response = userRemoteDataSource.signUp(
                SignUpRequest(
                    name = request.name,
                    email = request.email,
                    password = request.password,
                    passwordConfirmation = request.passwordConfirmation
                )
            )
            response.data
        }
    }
}
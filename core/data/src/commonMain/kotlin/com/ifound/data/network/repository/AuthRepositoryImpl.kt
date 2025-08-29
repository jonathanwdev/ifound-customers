package com.ifound.data.network.repository

import com.ifound.data.network.dataSource.AuthRemoteDataSource
import com.ifound.data.network.dataSource.models.requests.ForgotPasswordRequest
import com.ifound.data.network.dataSource.models.requests.ResetPasswordRequest
import com.ifound.data.network.dataSource.models.requests.SignInRequest
import com.ifound.data.network.dataSource.models.requests.SignUpRequest
import com.ifound.data.network.dataSource.models.requests.ValidateTokenRequest
import com.ifound.domain.models.ForgotPassword
import com.ifound.domain.models.RegisterCustomer
import com.ifound.domain.models.ResetPassword
import com.ifound.domain.models.SignInCustomer
import com.ifound.domain.models.SignInToken
import com.ifound.domain.models.ValidateToken
import com.ifound.domain.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


class AuthRepositoryImpl(
    private val userRemoteDataSource: AuthRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher,
) : AuthRepository {
    override suspend fun signUp(request: RegisterCustomer): Result<String> {
        return withContext(ioDispatcher) {
            runCatching {
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

    override suspend fun signIn(request: SignInCustomer): Result<SignInToken> {
        return withContext(ioDispatcher) {
            runCatching {
                val response = userRemoteDataSource.signIn(
                    SignInRequest(
                        email = request.email,
                        password = request.password,
                    )
                )
                SignInToken(
                    token = response.data.token
                )
            }
        }
    }

    override suspend fun forgotPassword(request: ForgotPassword): Result<String> {
        return withContext(ioDispatcher) {
            runCatching {
                val response = userRemoteDataSource.forgotPassword(
                    ForgotPasswordRequest(
                        email = request.email
                    )
                )
                response.data

            }
        }
    }

    override suspend fun validateTokenPassword(request: ValidateToken): Result<Boolean> {
        return withContext(ioDispatcher) {
            runCatching {
                val response = userRemoteDataSource.validateTokenPassword(
                    ValidateTokenRequest(
                        email = request.email,
                        token = request.token
                    )
                )
                response.data.tokenIsValid
            }
        }
    }

    override suspend fun resetPassword(request: ResetPassword): Result<String> {
        return withContext(ioDispatcher) {
            runCatching {
                val response = userRemoteDataSource.resetPassword(
                    ResetPasswordRequest(
                        email = request.email,
                        password = request.password,
                        token = request.token,
                        passwordConfirmation = request.passwordConfirmation
                    )
                )
                response.data
            }
        }
    }
}
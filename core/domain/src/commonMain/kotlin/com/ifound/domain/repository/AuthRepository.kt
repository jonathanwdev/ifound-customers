package com.ifound.domain.repository

import com.ifound.domain.models.ForgotPassword
import com.ifound.domain.models.RegisterCustomer
import com.ifound.domain.models.ResetPassword
import com.ifound.domain.models.SignInCustomer
import com.ifound.domain.models.SignInToken
import com.ifound.domain.models.ValidateToken

interface AuthRepository {
    suspend fun signUp(request: RegisterCustomer): Result<String>
    suspend fun signIn(request: SignInCustomer): Result<SignInToken>
    suspend fun forgotPassword(request: ForgotPassword): Result<String>
    suspend fun validateTokenPassword(request: ValidateToken): Result<Boolean>
    suspend fun resetPassword(request: ResetPassword): Result<String>

}

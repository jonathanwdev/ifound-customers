package com.ifound.domain.repository

import com.ifound.domain.models.RegisterCustomer

interface AuthRepository {
    suspend fun signUp(request: RegisterCustomer): Result<String>

}

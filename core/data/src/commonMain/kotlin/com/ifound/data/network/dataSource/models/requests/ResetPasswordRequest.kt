package com.ifound.data.network.dataSource.models.requests

import com.ifound.data.network.dataSource.models.UserType
import kotlinx.serialization.Serializable

@Serializable
data class ResetPasswordRequest(
    val email: String,
    val password: String,
    val token: String,
    val passwordConfirmation: String,
    val userType: UserType = UserType.CUSTOMER
)


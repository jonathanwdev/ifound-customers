package com.ifound.data.network.dataSource.models.requests

import com.ifound.data.network.dataSource.models.UserType
import kotlinx.serialization.Serializable

@Serializable
data class ForgotPasswordRequest(
    val email: String,
    val userType: UserType = UserType.CUSTOMER
)

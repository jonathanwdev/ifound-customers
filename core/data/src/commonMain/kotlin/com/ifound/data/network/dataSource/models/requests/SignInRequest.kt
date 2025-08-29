package com.ifound.data.network.dataSource.models.requests

import com.ifound.data.network.dataSource.models.UserType
import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(
    val email: String,
    val password: String,
    val userType: UserType = UserType.CUSTOMER
)
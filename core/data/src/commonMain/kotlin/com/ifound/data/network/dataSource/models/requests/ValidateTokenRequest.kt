package com.ifound.data.network.dataSource.models.requests

import com.ifound.data.network.dataSource.models.UserType
import kotlinx.serialization.Serializable


@Serializable
data class ValidateTokenRequest(
    val email: String,
    val token: String,
    val userType: UserType = UserType.CUSTOMER
)





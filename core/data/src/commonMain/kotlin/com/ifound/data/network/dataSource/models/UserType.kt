package com.ifound.data.network.dataSource.models

import kotlinx.serialization.Serializable

@Serializable
enum class UserType {
    CUSTOMER,
    EMPLOYEE
}
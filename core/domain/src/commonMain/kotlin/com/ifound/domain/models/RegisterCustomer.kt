package com.ifound.domain.models

data class RegisterCustomer(
    val name: String,
    val email: String,
    val password: String,
    val passwordConfirmation: String,
)

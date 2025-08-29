package com.ifound.domain.models

data class ResetPassword(
    val email: String,
    val password: String,
    val token: String,
    val passwordConfirmation: String,
)

package com.ifound.domain.models

data class ValidateToken(
    val email: String,
    val token: String,
)

package com.ifound.sign.presentation.screens.signIn

data class SignInUiState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val httpError: String? = null,
    val isLoading: Boolean = false,
)

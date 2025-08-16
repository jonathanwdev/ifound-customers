package com.ifound.sign.presentation.screens.signUp

data class SignUpScreenState(
    val isLoading: Boolean = false,
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val passwordConfirmation: String = "",
    val address: String = "",
)
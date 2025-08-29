package com.ifound.sign.presentation.screens.signUp

data class SignUpUiState(
    val isLoading: Boolean = false,
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val passwordConfirmation: String = "",
    val address: String = "",
)
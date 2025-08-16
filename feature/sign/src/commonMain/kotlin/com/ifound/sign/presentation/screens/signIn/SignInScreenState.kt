package com.ifound.sign.presentation.screens.signIn

data class SignInScreenState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
)

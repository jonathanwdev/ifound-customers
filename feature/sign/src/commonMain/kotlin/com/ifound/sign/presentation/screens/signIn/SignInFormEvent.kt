package com.ifound.sign.presentation.screens.signIn

sealed interface SignInFormEvent {
    data class OnEmailChanged(val email: String) : SignInFormEvent
    data class OnPasswordChanged(val password: String) : SignInFormEvent
    data object OnSubmit : SignInFormEvent
}
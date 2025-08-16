package com.ifound.sign.presentation.screens.signUp

sealed interface SignUpFormEvent {
    data class OnNameChanged(val name: String) : SignUpFormEvent
    data class OnEmailChanged(val email: String) : SignUpFormEvent
    data class OnPasswordChanged(val password: String) : SignUpFormEvent
    data class OnPasswordConfirmationChanged(val passwordConfirmation: String) : SignUpFormEvent
    data class OnAddressChanged(val address: String) : SignUpFormEvent
    data object OnSubmit : SignUpFormEvent

}
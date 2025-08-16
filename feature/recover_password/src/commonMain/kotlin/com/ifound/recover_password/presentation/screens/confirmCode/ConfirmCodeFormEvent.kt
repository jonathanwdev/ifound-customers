package com.ifound.recover_password.presentation.screens.confirmCode

sealed interface ConfirmCodeFormEvent {
    data class OnChangeCode(val code: String) : ConfirmCodeFormEvent
    data object OnRetrySendCode : ConfirmCodeFormEvent
    data class OnSubmit(val onSuccess: () -> Unit) : ConfirmCodeFormEvent
}
package com.ifound.recover_password.presentation.screens.confirmCode

data class ConfirmCodeScreenState(
    val code: String = "",
    val isLoading: Boolean = false
)
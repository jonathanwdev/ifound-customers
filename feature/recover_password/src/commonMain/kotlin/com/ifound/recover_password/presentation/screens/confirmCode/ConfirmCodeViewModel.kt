package com.ifound.recover_password.presentation.screens.confirmCode

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ConfirmCodeViewModel : ViewModel() {
    var state by mutableStateOf(ConfirmCodeScreenState())
        private set

    fun onEvent(event: ConfirmCodeFormEvent) {
        when (event) {
            is ConfirmCodeFormEvent.OnChangeCode -> {
                state = state.copy(code = event.code)
            }
            ConfirmCodeFormEvent.OnRetrySendCode -> {
                sendCodeAgain()
            }
            is ConfirmCodeFormEvent.OnSubmit -> {
                confirmCode(event.onSuccess)
            }
        }
    }

    private fun confirmCode(
        onSuccess: () -> Unit
    ) {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            delay(2000)
            state = state.copy(isLoading = false)
            onSuccess()
        }
    }

    private fun sendCodeAgain(
    ) {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            delay(2000)
            state = state.copy(isLoading = false)
        }
    }



}
package com.ifound.sign.presentation.screens.signIn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignInViewModel: ViewModel() {
    var screenState by mutableStateOf(SignInScreenState())
        private set


    fun onFormEvent(event: SignInFormEvent) {
        when(event) {
            is SignInFormEvent.OnEmailChanged -> {
                screenState = screenState.copy(email = event.email)
            }
            is SignInFormEvent.OnPasswordChanged -> {
                screenState = screenState.copy(password = event.password)
            }
            is SignInFormEvent.OnSubmit -> {
                submitData()
            }
        }
    }

    private fun submitData() {}
}
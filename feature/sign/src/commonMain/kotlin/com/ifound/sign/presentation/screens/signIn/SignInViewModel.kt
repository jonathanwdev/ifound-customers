package com.ifound.sign.presentation.screens.signIn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ifound.domain.models.SignInCustomer
import com.ifound.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SignInViewModel(
    private val authRepository: AuthRepository,
) : ViewModel() {

    var uiState by mutableStateOf(SignInUiState())
        private set

    private val _event = MutableSharedFlow<SignInScreenEvents>()
    val event: SharedFlow<SignInScreenEvents> = _event.asSharedFlow()


    fun onFormEvent(event: SignInFormEvent) {
        when (event) {
            is SignInFormEvent.OnEmailChanged -> {
                uiState = uiState.copy(email = event.email, emailError = null)
            }

            is SignInFormEvent.OnPasswordChanged -> {
                uiState = uiState.copy(password = event.password, passwordError = null)
            }

            is SignInFormEvent.OnSubmit -> {
                submitData()
            }
        }
    }

    private fun clearErrors() {
        uiState = uiState.copy(emailError = null, passwordError = null)
    }

    private fun submitData() {
//
//        clearErrors()
//        if (uiState.email.isEmpty()) {
//            uiState = uiState.copy(emailError = "Email is required")
//        }
//        if (uiState.password.isEmpty()) {
//            uiState = uiState.copy(passwordError = "Password is required")
//        }
//        if(uiState.emailError != null || uiState.passwordError != null) return
//        uiState = uiState.copy(isLoading = true)
        viewModelScope.launch {
            _event.emit(SignInScreenEvents.SignSuccess)
            return@launch
//            authRepository.signIn(
//                SignInCustomer(
//                    email = uiState.email,
//                    password = uiState.password
//                )
//            ).fold(
//                onSuccess = {
//                    _event.emit(SignInScreenEvents.SignSuccess)
//                    uiState = uiState.copy(isLoading = false)
//
//                },
//                onFailure = {
//                    _event.emit(SignInScreenEvents.SignError)
//                    uiState = uiState.copy(
//                        isLoading = false,
//                        passwordError = "Email or password is incorrect",
//                        emailError = "Email or password is incorrect"
//                    )
//
//                },
//            )
        }
    }


    sealed interface SignInScreenEvents {
        data object SignSuccess : SignInScreenEvents
        data object SignError : SignInScreenEvents
    }
}
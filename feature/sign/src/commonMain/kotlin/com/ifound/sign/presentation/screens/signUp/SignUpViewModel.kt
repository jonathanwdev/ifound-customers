package com.ifound.sign.presentation.screens.signUp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ifound.domain.models.RegisterCustomer
import com.ifound.domain.repository.AuthRepository
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    var state by mutableStateOf(SignUpScreenState())
        private set

    fun formEvent(event: SignUpFormEvent) {
        when (event) {
            is SignUpFormEvent.OnNameChanged -> {
                state = state.copy(name = event.name)
            }
            is SignUpFormEvent.OnEmailChanged -> {
                state = state.copy(email = event.email)
            }
            is SignUpFormEvent.OnPasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is SignUpFormEvent.OnPasswordConfirmationChanged -> {
                state = state.copy(passwordConfirmation = event.passwordConfirmation)
            }
            is SignUpFormEvent.OnAddressChanged -> {
                state = state.copy(address = event.address)
            }
            is SignUpFormEvent.OnSubmit -> {
                singUp()
            }
        }
    }

    fun singUp() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            authRepository.signUp(
                RegisterCustomer(
                    name = state.name,
                    email = state.email,
                    password = state.password,
                    passwordConfirmation = state.passwordConfirmation
                )
            ).fold(
                onSuccess = {
                    state = state.copy(isLoading = false)
                },
                onFailure = {
                    state = state.copy(isLoading = false)
                }
            )
        }
    }
}
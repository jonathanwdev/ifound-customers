package com.ifound.sign.presentation.screens.signUp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ifound.common.utils.Platform
import com.ifound.common.utils.currentPlatform
import com.ifound.domain.models.RegisterCustomer
import com.ifound.domain.repository.AuthRepository
import com.ifound.domain.repository.LocalLocationRepository
import dev.icerock.moko.geo.LocationTracker
import dev.icerock.moko.permissions.PermissionsController
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val authRepository: AuthRepository,
    private val localLocationRepository: LocalLocationRepository,
    val locationTracker: LocationTracker,
    val permissionsController: PermissionsController,
) : ViewModel() {
    var uiState by mutableStateOf(SignUpUiState())
        private set

    init {
        if (currentPlatform == Platform.ANDROID) {
            viewModelScope.launch {
                locationTracker.startTracking()
            }
        }
    }

    fun getLocation() {
        viewModelScope.launch {
            if (currentPlatform == Platform.IOS) {
                locationTracker.startTracking()
            }
            val locations = localLocationRepository.getCurrentLocation().fold(
                onSuccess = {
                    if (currentPlatform == Platform.IOS) {
                        locationTracker.stopTracking()
                    }
                    it
                },
                onFailure = {
                    null
                    if (currentPlatform == Platform.IOS) {
                        locationTracker.stopTracking()
                    }
                }
            )

        }
    }

    override fun onCleared() {
        super.onCleared()
        if (currentPlatform == Platform.ANDROID) {
            locationTracker.stopTracking()
        }
    }


    fun formEvent(event: SignUpFormEvent) {
        when (event) {
            is SignUpFormEvent.OnNameChanged -> {
                uiState = uiState.copy(name = event.name)
            }

            is SignUpFormEvent.OnEmailChanged -> {
                uiState = uiState.copy(email = event.email)
            }

            is SignUpFormEvent.OnPasswordChanged -> {
                uiState = uiState.copy(password = event.password)
            }

            is SignUpFormEvent.OnPasswordConfirmationChanged -> {
                uiState = uiState.copy(passwordConfirmation = event.passwordConfirmation)
            }

            is SignUpFormEvent.OnAddressChanged -> {
                uiState = uiState.copy(address = event.address)
            }

            is SignUpFormEvent.OnSubmit -> {
                singUp()
            }
        }
    }

    fun singUp() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            authRepository.signUp(
                RegisterCustomer(
                    name = uiState.name,
                    email = uiState.email,
                    password = uiState.password,
                    passwordConfirmation = uiState.passwordConfirmation
                )
            ).fold(
                onSuccess = {
                    uiState = uiState.copy(isLoading = false)
                },
                onFailure = {
                    uiState = uiState.copy(isLoading = false)
                }
            )
        }
    }
}
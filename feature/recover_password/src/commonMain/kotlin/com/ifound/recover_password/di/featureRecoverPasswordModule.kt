package com.ifound.recover_password.di

import com.ifound.recover_password.presentation.screens.confirmCode.ConfirmCodeViewModel
import com.ifound.recover_password.presentation.screens.createNewPassword.CreateNewPasswordViewModel
import com.ifound.recover_password.presentation.screens.forgotPassword.ForgotPasswordViewModel
import com.ifound.recover_password.presentation.screens.passwordUpdated.PasswordUpdatedViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureRecoverPasswordModule = module {
    viewModelOf(::ConfirmCodeViewModel)
    viewModelOf(::CreateNewPasswordViewModel)
    viewModelOf(::ForgotPasswordViewModel)
    viewModelOf(::PasswordUpdatedViewModel)
}
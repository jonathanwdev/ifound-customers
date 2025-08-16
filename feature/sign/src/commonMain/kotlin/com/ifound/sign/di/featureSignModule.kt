package com.ifound.sign.di

import com.ifound.sign.presentation.screens.signIn.SignInViewModel
import com.ifound.sign.presentation.screens.signUp.SignUpViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureSignModule = module {
    viewModelOf(::SignInViewModel)
    viewModelOf(::SignUpViewModel)

}
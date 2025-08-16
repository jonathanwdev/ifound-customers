package com.ifound.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    data object SignBaseRoute : Routes()

    @Serializable
    data object SignIn : Routes()

    @Serializable
    data object SignUp : Routes()

    @Serializable
    data object PasswordRecoverBaseRoute : Routes()
    @Serializable
    data object ForgotPassword : Routes()

    @Serializable
    data object Home : Routes()

    @Serializable
    data object ConfirmCode : Routes()

    @Serializable
    data object CreateNewPassword : Routes()

    @Serializable
    data object PasswordUpdated : Routes()

}
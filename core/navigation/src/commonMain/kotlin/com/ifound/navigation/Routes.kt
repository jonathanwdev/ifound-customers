package com.ifound.navigation

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

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
    data object ConfirmCode : Routes()

    @Serializable
    data object CreateNewPassword : Routes()

    @Serializable
    data object PasswordUpdated : Routes()

    @Serializable
    data object StoresBaseRoute : Routes()

    @Serializable
    data object Home : Routes()

    @Serializable
    data object StoreDetails: Routes()

    @Serializable
    data object OurTeam: Routes()

    @Serializable
    data object OurServices: Routes()

    @Serializable
    data object AppointmentBaseRoute : Routes()

    @Serializable
    data object BookAppointment: Routes()

    @Serializable
    data object AppointmentSummary: Routes()

    @Serializable
    data object AppointmentConfirmation: Routes()


}
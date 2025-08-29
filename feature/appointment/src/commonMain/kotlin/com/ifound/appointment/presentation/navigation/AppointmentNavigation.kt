package com.ifound.appointment.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ifound.appointment.presentation.screens.appointmentConfirmation.AppointmentConfirmationScreen
import com.ifound.appointment.presentation.screens.appointmentSummary.AppointmentSummaryScreen
import com.ifound.appointment.presentation.screens.bookAppointment.BookAppointmentScreen
import com.ifound.navigation.Routes

fun NavGraphBuilder.appointmentNavigation(
    navController: NavController
) {
    navigation<Routes.AppointmentBaseRoute>(startDestination = Routes.BookAppointment) {
        composable<Routes.BookAppointment> {
            BookAppointmentScreen()
        }
        composable<Routes.AppointmentSummary> {
            AppointmentSummaryScreen()
        }

        composable<Routes.AppointmentConfirmation> {
            AppointmentConfirmationScreen()
        }


    }
}
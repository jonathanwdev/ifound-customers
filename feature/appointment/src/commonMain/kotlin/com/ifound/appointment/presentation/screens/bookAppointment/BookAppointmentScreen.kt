package com.ifound.appointment.presentation.screens.bookAppointment

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ifound.appointment.presentation.components.AppointmentStepsCounter
import com.ifound.appointment.presentation.components.SelectDateStep
import com.ifound.appointment.presentation.components.SelectEmployeeStep
import com.ifound.appointment.presentation.components.SelectServiceStep
import com.ifound.ui.UiRes
import com.ifound.ui.components.common.CommonButton
import com.ifound.ui.components.topBars.TopBarLeadingIconCenteredText
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BookAppointmentScreen() {
    BookAppointmentView()
}

sealed interface AppointmentStep {
    data object Service : AppointmentStep
    data object Employee : AppointmentStep
    data object Date : AppointmentStep
}

@Composable
fun BookAppointmentView() {

    var step by remember { mutableStateOf<AppointmentStep>(AppointmentStep.Service) }

    var selectedService by remember { mutableStateOf(-1) }
    var selectedEmployee by remember { mutableStateOf(-1) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopBarLeadingIconCenteredText(
                title = "Book Appointment",
                icon = UiRes.Drawable.ic_arrow_back,
                onLeadingIconClick = {}
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .padding(
                    horizontal = Spacings.MARGIN_HORIZONTAL
                )

        ) {

            val parsedToNumber = when (step) {
                AppointmentStep.Service -> 1
                AppointmentStep.Employee -> 2
                AppointmentStep.Date -> 3
            }
            AppointmentStepsCounter(
                modifier = Modifier.padding(horizontal = 5.dp),
                currentStep = parsedToNumber
            )
            Spacer(Modifier.height(15.dp))
            AnimatedContent(
                targetState = step,
                modifier = Modifier.weight(1f),
                label = "appointment_step",
                transitionSpec = {
                    (slideIntoContainer(
                        animationSpec = tween(600),
                        towards = AnimatedContentTransitionScope.SlideDirection.Left
                    ) togetherWith slideOutOfContainer(
                        animationSpec = tween(600),
                        towards = AnimatedContentTransitionScope.SlideDirection.Right
                    ))
                }
            ) { currentStep ->
                when (currentStep) {
                    AppointmentStep.Service -> {
                        SelectServiceStep(
                            modifier = Modifier,
                            selected = selectedService,
                            items = listOf("Hair Cut Degrade", "Face massage", "Common Hair cut", "Hair Cut Degrade", "Face massage", "Common Hair cut"),
                            onSelect = { selectedOption ->
                                selectedService = selectedOption
                            }
                        )
                    }

                    AppointmentStep.Employee -> {
                        SelectEmployeeStep(
                            modifier = Modifier,
                            selected = selectedEmployee,
                            onSelect = { selectedOption ->
                                selectedEmployee = selectedOption
                            },
                            items = listOf("John Doe", "Michael Owen", "Zico", "Carl Luc", "Mark Jackson", "Donovan Doe", "Eugene Heracles", "Zizu"),
                        )
                    }

                    AppointmentStep.Date -> {
                        SelectDateStep(
                            modifier = Modifier
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            CommonButton(
                text = "Continue",
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    if (step == AppointmentStep.Date) {
                        step = AppointmentStep.Service
                        return@CommonButton
                    }
                    if (step == AppointmentStep.Service) {
                        step = AppointmentStep.Employee
                        return@CommonButton
                    }
                    if (step == AppointmentStep.Employee) {
                        step = AppointmentStep.Date
                        return@CommonButton
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BookAppointmentViewPreview() {
    IfoundTheme {
        BookAppointmentView()
    }
}
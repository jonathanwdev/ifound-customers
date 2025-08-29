package com.ifound.appointment.presentation.screens.appointmentConfirmation


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ifound.ui.UiRes
import com.ifound.ui.components.common.CommonButton
import com.ifound.ui.components.topBars.TopBarLeadingIconCenteredText
import com.ifound.ui.models.ButtonStyle
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppointmentConfirmationScreen() {
    AppointmentConfirmationView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentConfirmationView() {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopBarLeadingIconCenteredText(
                title = "Booking Confirmed",
                icon = UiRes.Drawable.ic_close,
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

        ) {
            Image(
                painter = painterResource(UiRes.Drawable.placeholder_dev_salon),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.3f)
            )
            Column(
                modifier = Modifier
                    .padding(Spacings.MARGIN_HORIZONTAL)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Your Appointment is confirmed!",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "You're all set for your appointment with Alex at The Sharp Edge Barbershop on Friday. July 26th at 2:00PM.",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Medium)
                )
                CommonButton(
                    text = "View Booking",
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.padding(top = 30.dp),
                    onClick = {}
                )
                CommonButton(
                    text = "Add to Calendar",
                    shape = MaterialTheme.shapes.medium,
                    buttonStyle = ButtonStyle.Secondary,
                    modifier = Modifier.padding(top = 10.dp),
                    onClick = {}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppointmentConfirmationViewPreview() {
    IfoundTheme {
        AppointmentConfirmationView()
    }
}
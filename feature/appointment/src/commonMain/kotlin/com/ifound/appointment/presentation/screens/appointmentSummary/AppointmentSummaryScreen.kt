package com.ifound.appointment.presentation.screens.appointmentSummary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ifound.appointment.presentation.components.AppointmentStepsCounter
import com.ifound.ui.UiRes
import com.ifound.ui.components.common.CommonButton
import com.ifound.ui.components.topBars.TopBarLeadingIconCenteredText
import com.ifound.ui.theme.Alpha
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import com.ifound.ui.theme.White
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppointmentSummaryScreen() {
    AppointmentSummaryView()
}

@Composable
fun AppointmentSummaryView() {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopBarLeadingIconCenteredText(
                title = "Book Appointment",
                icon = UiRes.Drawable.ic_arrow_back,
                actionIcon = UiRes.Drawable.ic_close,
                onLeadingIconClick = {},
                onActionIconClick = {},
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
            AppointmentStepsCounter(
                modifier = Modifier.padding(horizontal = 5.dp),
                isFinished = true,
                currentStep = 3
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Summary & Confirmation",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(Modifier.height(15.dp))
            Box(
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .shadow(
                            elevation = 2.dp,
                            shape = MaterialTheme.shapes.medium
                        ).fillMaxWidth()
                        .background(White)
                        .clip(MaterialTheme.shapes.medium)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = Alpha.DISABLED),
                            shape = MaterialTheme.shapes.medium
                        )
                        .padding(horizontal = 22.dp, vertical = 22.dp)
                ) {
                    Column {
                        Text(
                            text = "Service",
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = Alpha.HALF)
                        )
                        Text(
                            text = "Haircut and beard",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 15.dp),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = Alpha.DISABLED)
                        )
                        Row(
                            modifier = Modifier.height(IntrinsicSize.Max)
                        ) {
                            Column {
                                Text(
                                    text = "Employee",
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = Alpha.HALF)
                                )
                                Spacer(Modifier.height(10.dp))
                                Image(
                                    painter = painterResource(UiRes.Drawable.placeholder_dev_barber),
                                    contentScale = ContentScale.Crop,
                                    contentDescription = "Employee",
                                    modifier = Modifier.clip(CircleShape).size(55.dp)
                                )

                            }
                            Spacer(Modifier.width(10.dp))
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Bottom,
                            ) {
                                Text(
                                    text = "John Doe",
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(UiRes.Drawable.ic_star_filled),
                                        contentDescription = "Rating",
                                        tint = MaterialTheme.colorScheme.secondary,
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Spacer(Modifier.width(7.dp))
                                    Text(
                                        text = "4.9",
                                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                        color = MaterialTheme.colorScheme.secondary
                                    )
                                }
                            }
                        }
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 15.dp),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = Alpha.DISABLED)
                        )
                        Column(
                            modifier = Modifier,
                        ) {
                            Text(
                                text = "Date & Time",
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = Alpha.HALF)
                            )
                            Text(
                                text = "August 28, 2024 - 10:00AM",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 15.dp),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = Alpha.DISABLED)
                        )
                        Column(
                            modifier = Modifier,
                        ) {
                            Text(
                                text = "Total",
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = Alpha.HALF)
                            )
                            Text(
                                text = "$45.00",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }

                    }
                }
            }
            CommonButton(
                text = "Confirm Appointment",
                shape = MaterialTheme.shapes.medium,
                leadingIcon = UiRes.Drawable.ic_checked_circle,
                onClick = {

                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppointmentSummaryViewPreview() {
    IfoundTheme {
        AppointmentSummaryView()
    }
}
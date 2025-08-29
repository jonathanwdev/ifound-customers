package com.ifound.appointment.presentation.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ifound.ui.UiRes
import com.ifound.ui.theme.GrayPrimary
import com.ifound.ui.theme.GraySecondary
import com.ifound.ui.theme.IfoundTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun AppointmentStepsCounter(
    modifier: Modifier = Modifier,
    isFinished: Boolean = false,
    currentStep: Int = 0,
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Step(
            title = "Service",
            stepNumber = "1",
            hasLine = false,
            isActive = currentStep > 0 || isFinished,
            isFinished = isFinished,
        )
        Step(
            title = "Employee",
            stepNumber = "2",
            hasLine = true,
            isActive = currentStep > 1 || isFinished,
            isFinished = isFinished,
        )
        Step(
            title = "Date",
            stepNumber = "3",
            hasLine = true,
            isActive = currentStep > 2 || isFinished,
            isFinished = isFinished,
        )
    }

}


@Composable
fun RowScope.Step(
    title: String,
    stepNumber: String,
    hasLine: Boolean,
    isActive: Boolean,
    isFinished: Boolean,
) {
    val transition = updateTransition(targetState = isActive, label = "box")

    val bgColor by transition.animateColor {
        if (it) MaterialTheme.colorScheme.secondary else GrayPrimary
    }
    val textColor by transition.animateColor(
        label = "text",
        transitionSpec = {
            tween(durationMillis = 600)
        }
    ) {
        if (it) MaterialTheme.colorScheme.surface else GraySecondary
    }

    if (hasLine) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp)
                .background(bgColor)
                .height(2.dp)
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isFinished) {
            Icon(
                painter = painterResource(UiRes.Drawable.ic_checked_circle),
                modifier = Modifier.size(30.dp),
                tint = bgColor,
                contentDescription = null,
            )
        } else {
            Box(
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .background(bgColor)
                    .size(30.dp),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = stepNumber,
                    color = textColor,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

        }
        Spacer(Modifier.height(3.dp))
        Text(
            text = title,
            color = bgColor,
            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold)
        )
    }


}


@Preview
@Composable
private fun AppointmentStepsCounterPreview() {
    IfoundTheme {
        AppointmentStepsCounter()
    }
}



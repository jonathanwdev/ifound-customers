package com.ifound.appointment.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ifound.ui.UiRes
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.White
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.time.ExperimentalTime


data class DateFormatted(
    val fullDate: String,
    val month: String,
    val year: String,
    val dayOrdinal: String,
    val dayName: String
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalTime::class)
@Composable
fun SelectDateStep(
    modifier: Modifier = Modifier
) {
    var now by remember { mutableStateOf(Clock.System.now()) }

    fun addDay() {
        now = now.plus(1, DateTimeUnit.DAY, TimeZone.UTC)
    }

    fun subDay() {
        now = now.plus(-1, DateTimeUnit.DAY, TimeZone.UTC)
    }

    val currentDateSelected by derivedStateOf {
        now.toLocalDateTime(TimeZone.currentSystemDefault()).date.let { date ->
            val month = MonthNames.ENGLISH_FULL.names[date.month.ordinal]
            val day = date.dayOfMonth
            val year = date.year

            DateFormatted(
                fullDate = date.toString(),
                month = month,
                year = year.toString(),
                dayOrdinal = day.toString(),
                dayName = date.dayOfWeek.name
            )
        }
    }


    Column(
        modifier = modifier
    ) {
        Text(
            text = "Select Date & Time:",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(Modifier.height(15.dp))
        Card(
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 2.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = White
            ),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp, vertical = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {
                            subDay()
                        },
                    ) {
                        Icon(
                            painter = painterResource(UiRes.Drawable.ic_chevron_backward),
                            modifier = Modifier.size(24.dp),
                            contentDescription = null
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = currentDateSelected.month,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text = currentDateSelected.year,
                        )
                    }
                    IconButton(
                        onClick = {
                            addDay()
                        }
                    ) {
                        Icon(
                            painter = painterResource(UiRes.Drawable.ic_chevron_forward),
                            modifier = Modifier.size(24.dp),
                            contentDescription = null
                        )
                    }
                }
                Spacer(Modifier.height(15.dp))
                AnimatedContent(
                    targetState = currentDateSelected,
                    modifier = Modifier.padding(horizontal = 5.dp),
                    label = "date_picker",
                    transitionSpec = {
                        if (targetState.fullDate.compareTo(initialState.fullDate) > 0) {
                            slideInHorizontally { width -> width } togetherWith slideOutHorizontally { width -> -width }
                        } else {
                            slideInHorizontally { width -> -width } togetherWith slideOutHorizontally { width -> width }
                        }.using(
                            SizeTransform(clip = false)
                        )
                    }
                ) { currentDateSelectedTarget ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = currentDateSelectedTarget.dayName,
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold)
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = currentDateSelectedTarget.dayOrdinal,
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold)
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(15.dp))
        Text(
            text = "Available Times",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(Modifier.height(15.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(
                count = 12
            ) {
                Card(
                    modifier = Modifier.height(70.dp).weight(1f),
                    colors = CardDefaults.cardColors(
                        containerColor = White
                    ),
                    shape = MaterialTheme.shapes.medium,
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = 2.dp
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "09:00",
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text = "AM",
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold)
                        )
                    }
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun SelectDateStepPreview() {
    IfoundTheme {
        SelectDateStep()
    }
}
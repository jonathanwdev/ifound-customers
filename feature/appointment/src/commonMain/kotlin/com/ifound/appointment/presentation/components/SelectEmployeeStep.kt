package com.ifound.appointment.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ifound.ui.UiRes
import com.ifound.ui.theme.GrayPrimary
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.White
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SelectEmployeeStep(
    modifier: Modifier = Modifier,
    selected: Int,
    items: List<String>,
    onSelect: (Int) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item {
            Text(
                text = "Select the Employee:",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
        }
        itemsIndexed(items) { index, item ->
            val isSelected = selected == index
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = White
                ),
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(
                    width = if (isSelected) 1.dp else 0.dp,
                    color = if (isSelected) MaterialTheme.colorScheme.secondary else Color.Transparent
                ),
                elevation = CardDefaults.elevatedCardElevation(1.dp)
            ) {
                Box(
                    modifier = Modifier
                        .animateContentSize(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = item,
                                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)

                                )
                                Text(
                                    text = "Barber",
                                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }
                            IconButton(
                                onClick = {
                                    onSelect(index)
                                }
                            ) {
                                if (isSelected) {
                                    Icon(
                                        painter = painterResource(UiRes.Drawable.ic_checked_circle),
                                        tint = MaterialTheme.colorScheme.secondary,
                                        modifier = Modifier.size(30.dp),
                                        contentDescription = null,
                                    )
                                } else {
                                    Box(
                                        modifier = Modifier
                                            .size(25.dp).clip(
                                                CircleShape
                                            ).border(
                                                width = 1.dp,
                                                color = GrayPrimary,
                                                shape = CircleShape
                                            )
                                    )
                                }

                            }
                        }
                        if (isSelected) {
                            Column {
                                Spacer(Modifier.height(10.dp))
                                Row {
                                    Image(
                                        modifier = Modifier
                                            .border(
                                                width = 3.dp,
                                                color = MaterialTheme.colorScheme.secondary,
                                                shape = CircleShape
                                            )
                                            .clip(
                                                CircleShape
                                            )
                                            .height(130.dp)
                                            .width(130.dp),
                                        painter = painterResource(UiRes.Drawable.placeholder_dev_barber),
                                        contentScale = ContentScale.Crop,
                                        contentDescription = null
                                    )
                                    Spacer(Modifier.width(15.dp))
                                    val services = listOf(
                                        "Degrade",
                                        "Hair cut",
                                        "Face massage",
                                        "Millitary cut"
                                    )
                                    Column {
                                        Text(
                                            text = services.joinToString { "${it}" },
                                            style = MaterialTheme.typography.labelMedium.copy(
                                                fontWeight = FontWeight.SemiBold
                                            ),
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis,
                                            color = MaterialTheme.colorScheme.secondary
                                        )
                                        Spacer(Modifier.height(5.dp))
                                        Text(
                                            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque bibendum aliquam nunc. Sed vel lacus in magna bibendum consectetur ut id lectus. Suspendisse dapibus interdum urna vel lacinia. Nulla facilisi. Nullam tempus tortor vitae tortor dignissim euismod. Aliquam arcu eros, porta eget tempor tristique, rhoncus sit amet nulla. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut sollicitudin dignissim vulputate",
                                            style = MaterialTheme.typography.bodyMedium.copy(
                                                fontWeight = FontWeight.Medium
                                            ),
                                            maxLines = 5,
                                            overflow = TextOverflow.Ellipsis,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )


                                    }
                                }


                            }
                        }

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectEmployeeStepPreview() {
    IfoundTheme {
        SelectEmployeeStep(
            selected = 0,
            items = listOf(
                "John Doe",
                "Michael Owen",
                "Zico",
                "Carl Luc",
                "Mark Jackson",
                "Donovan Doe",
                "Eugene Heracles",
                "Zizu"
            ),
            onSelect = {}
        )
    }
}
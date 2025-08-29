package com.ifound.stores.presentation.screens.storeDetails

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifound.ui.UiRes
import com.ifound.ui.components.common.CommonButton
import com.ifound.ui.components.common.CommonTextButton
import com.ifound.ui.components.topBars.TopBarLeadingIconCenteredText
import com.ifound.ui.models.ButtonSizes
import com.ifound.ui.models.ButtonStyle
import com.ifound.ui.theme.Alpha
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import com.ifound.ui.theme.White
import ifound.feature.stores.generated.resources.Res
import ifound.feature.stores.generated.resources.about_us
import ifound.feature.stores.generated.resources.book
import ifound.feature.stores.generated.resources.book_now
import ifound.feature.stores.generated.resources.click_to_see_us_on_map
import ifound.feature.stores.generated.resources.location
import ifound.feature.stores.generated.resources.meet_us
import ifound.feature.stores.generated.resources.rating
import ifound.feature.stores.generated.resources.reviews
import ifound.feature.stores.generated.resources.services
import ifound.feature.stores.generated.resources.view_all
import ifound.feature.stores.generated.resources.years
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun StoreDetailsScreen(
    onNavigateBackToHome: () -> Unit,
    onNavigateToOurTeam: () -> Unit,
    onNavigateToOurServices: () -> Unit,
    onNavigateToBookAppointment: () -> Unit,
) {
    StoreDetailsView(
        onGoBackToHome = onNavigateBackToHome,
        onNavigateToMeetOutTeam = onNavigateToOurTeam,
        onNavigateToOurServices = onNavigateToOurServices,
        onNavigateToBookAppointment = onNavigateToBookAppointment
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun StoreDetailsView(
    onGoBackToHome: () -> Unit,
    onNavigateToMeetOutTeam: () -> Unit,
    onNavigateToOurServices: () -> Unit,
    onNavigateToBookAppointment: () -> Unit,
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopBarLeadingIconCenteredText(
                title = "Sr. Baron",
                icon = UiRes.Drawable.ic_arrow_back,
                onLeadingIconClick = {
                    onGoBackToHome()
                }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.Transparent
            ) {
                CommonButton(
                    shape = MaterialTheme.shapes.medium,
                    text = stringResource(Res.string.book_now),
                    leadingIcon = UiRes.Drawable.ic_calendar_clear,
                    modifier = Modifier.padding(horizontal = Spacings.MARGIN_HORIZONTAL),
                    onClick = onNavigateToBookAppointment
                )
            }

        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier.padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding()
            ).fillMaxSize()

        ) {
            item {
                Box(
                    modifier = Modifier.fillMaxWidth().height(212.dp)
                ) {
                    Image(
                        painter = painterResource(UiRes.Drawable.bg_massage_clinic),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.80f)
                    )
                    Box(
                        modifier = Modifier
                            .background(Color.Black.copy(alpha = Alpha.HALF))
                            .fillMaxWidth()
                            .fillMaxHeight(0.80f)
                    )
                    Image(
                        painter = painterResource(UiRes.Drawable.placeholder_dev_salon),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(90.dp)
                            .shadow(
                                shape = CircleShape,
                                elevation = 10.dp,
                                ambientColor = MaterialTheme.colorScheme.onSurface,
                                spotColor = MaterialTheme.colorScheme.onSurface
                            )
                            .border(
                                border = BorderStroke(3.dp, MaterialTheme.colorScheme.primary),
                                shape = CircleShape
                            )
                            .padding(3.dp)
                            .clip(CircleShape)

                            .align(Alignment.BottomCenter)

                    )
                }
            }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = Spacings.MARGIN_HORIZONTAL),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(15.dp))
                    Text(
                        text = "Sr Baron Barbershop",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Sao Jose, Sc",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(
                                shape = RoundedCornerShape(7.dp),
                                elevation = 4.dp,
                                ambientColor = MaterialTheme.colorScheme.onSurface,
                                spotColor = MaterialTheme.colorScheme.onSurface
                            )
                            .clip(RoundedCornerShape(7.dp))
                            .background(White)
                            .padding(vertical = 13.dp),

                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        StoreRatingItem(
                            value = "4.8",
                            label = stringResource(Res.string.rating)
                        )
                        StoreRatingItem(
                            value = "500+",
                            label = stringResource(Res.string.reviews)
                        )
                        StoreRatingItem(
                            value = "9",
                            label = stringResource(Res.string.years)
                        )

                    }
                }

            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = Spacings.MARGIN_HORIZONTAL)
                ) {
                    Text(
                        text = stringResource(Res.string.about_us),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ),
                    )
                    Text(
                        text = "Simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker incl",
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = Spacings.MARGIN_HORIZONTAL),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(Res.string.services),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ),
                    )
                    CommonButton(
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 2.dp,
                        ),
                        shape = MaterialTheme.shapes.medium,
                        text = stringResource(Res.string.view_all),
                        trailingIcon = UiRes.Drawable.ic_arrow_right,
                        sizes = ButtonSizes.SMALL,
                        buttonStyle = ButtonStyle.Tertiary,
                        onClick = onNavigateToOurServices
                    )

                }
                Spacer(modifier = Modifier.height(15.dp))
            }
            items(
                count = 3,

                ) {
                ServiceCard(
                    title = "Hari Cut - degrade",
                    description = "$5s5"
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
            item {
                Spacer(modifier = Modifier.height(15.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = Spacings.MARGIN_HORIZONTAL)
                ) {
                    Text(
                        text = stringResource(Res.string.location),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CommonTextButton(
                        text = stringResource(Res.string.click_to_see_us_on_map),
                        leadingIcon = UiRes.Drawable.ic_location_filled,
                        color = MaterialTheme.colorScheme.secondary,
                        onClick = {}
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
            item {
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = Spacings.MARGIN_HORIZONTAL),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(Res.string.meet_us),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ),
                    )
                    CommonButton(
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 2.dp,
                        ),
                        shape = MaterialTheme.shapes.medium,
                        text = stringResource(Res.string.view_all),
                        trailingIcon = UiRes.Drawable.ic_arrow_right,
                        sizes = ButtonSizes.SMALL,
                        buttonStyle = ButtonStyle.Tertiary,
                        onClick = onNavigateToMeetOutTeam
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
            items(
                count = 3,

                ) {
                ServiceCard(
                    title = "Jonas",
                    description = "Barber"
                )
                Spacer(modifier = Modifier.height(15.dp))
            }

        }
    }
}

@Composable
private fun StoreRatingItem(
    value: String,
    label: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun ServiceCard(
    title: String,
    description: String,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = Spacings.MARGIN_HORIZONTAL)
            .fillMaxWidth()
            .shadow(
                shape = RoundedCornerShape(7.dp),
                elevation = 2.dp,
                ambientColor = MaterialTheme.colorScheme.onSurface,
                spotColor = MaterialTheme.colorScheme.onSurface
            )
            .clip(RoundedCornerShape(7.dp))
            .background(White)
            .padding(vertical = 13.dp, horizontal = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth(0.6f)
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Text(
            text = stringResource(Res.string.book),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Preview(
    showBackground = true,
    heightDp = 1400
)
@Composable
private fun StoreDetailsViewPreview() {
    IfoundTheme {
        StoreDetailsView(
            onGoBackToHome = {},
            onNavigateToMeetOutTeam = {},
            onNavigateToOurServices = {},
            onNavigateToBookAppointment = {}
        )
    }
}
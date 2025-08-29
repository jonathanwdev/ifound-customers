package com.ifound.stores.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ifound.ui.UiRes
import com.ifound.ui.components.common.CommonButton
import com.ifound.ui.models.ButtonSizes
import com.ifound.ui.models.ButtonStyle
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.White
import ifound.feature.stores.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun StoreServiceCardItem(
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(140.dp),
        ) {
            Image(
                painter = painterResource(UiRes.Drawable.placeholder_dev_salon),
                modifier = Modifier
                    .clip(
                        shape = MaterialTheme.shapes.medium.copy(
                            topEnd = CornerSize(0.dp),
                            bottomEnd = CornerSize(0.dp)
                        )
                    )
                    .fillMaxHeight()
                    .fillMaxWidth(0.34f),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Spacer(Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 5.dp)
                    .padding(end = 10.dp)
                    .background(White)
                    .weight(1f),

                ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Haircut",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                        )
                        Text(
                            text = "$50",
                            color = MaterialTheme.colorScheme.secondary,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                        )
                    }
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = "Classic haircut wit our professional barber",
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CommonButton(
                        text = "Book",
                        buttonStyle = ButtonStyle.Secondary,
                        sizes = ButtonSizes.SMALL,
                        onClick = {}
                    )
                }

            }
        }
    }
}


@Preview()
@Composable
private fun StoreServiceCardItemPreview() {
    IfoundTheme {
        StoreServiceCardItem()
    }
}

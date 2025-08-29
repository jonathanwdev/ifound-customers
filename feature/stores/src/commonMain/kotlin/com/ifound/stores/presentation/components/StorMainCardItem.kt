package com.ifound.stores.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ifound.ui.UiRes
import com.ifound.ui.theme.GreenOpen
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.White
import ifound.feature.stores.generated.resources.Res

import ifound.feature.stores.generated.resources.opened
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun StoreMainCardItem(
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Card(
        onClick = onItemClick,
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = modifier
                .height(
                    220.dp
                )
                .clip(RoundedCornerShape(20.dp))
        ) {
            //        AsyncImage(
//            modifier = Modifier.width(IntrinsicSize.Min)
//                    .fillMaxHeight(0.55f)
//                    .clip(
//                        RoundedCornerShape(
//                            topEnd = 20.dp,
//                            topStart = 20.dp
//                        )
//                    ),
//            model = ImageRequest.Builder(LocalPlatformContext.current)
//                .data("https://static.wikia.nocookie.net/naruto/images/3/33/Naruto_Uzumaki_%28Parte_I_-_HD%29.png/revision/latest/scale-to-width-down/1200?cb=20160316113315&path-prefix=pt-br")
//                .crossfade(enable = true)
//                .build(),
//            contentDescription = "Store item thumbnail",
//            contentScale = ContentScale.Crop
//        )
            Image(
                painter = painterResource(UiRes.Drawable.placeholder_dev_salon),
                modifier = Modifier
                    .width(IntrinsicSize.Min)
                    .fillMaxHeight(0.55f)
                    .clip(
                        RoundedCornerShape(
                            topEnd = 20.dp,
                            topStart = 20.dp
                        )
                    ),
                contentDescription = "Store item thumbnail",
                contentScale = ContentScale.Crop
            )
            Column(modifier.padding(horizontal = 13.dp, vertical = 11.dp)) {
                Text(
                    text = "Sassoon Salon",
                    modifier = Modifier.padding(top = 2.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                )
                Spacer(modifier = Modifier.height(3.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "1.2km away",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.secondary,
                    )
                    Text(
                        text = stringResource(Res.string.opened),
                        style = MaterialTheme.typography.bodySmall,
                        color = GreenOpen,
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(
                            painter = painterResource(UiRes.Drawable.ic_star_filled),
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(14.dp),
                            contentDescription = "Store rating"
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            text = "5.5",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.secondary,
                        )
                    }

                }

            }


        }
    }

}

@Preview(showBackground = true)
@Composable
private fun StoreMainCardItemPreview() {
    IfoundTheme {
        StoreMainCardItem(
            onItemClick = {}
        )
    }
}
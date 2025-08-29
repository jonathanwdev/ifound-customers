package com.ifound.stores.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifound.ui.UiRes
import com.ifound.ui.theme.IfoundTheme
import ifound.feature.stores.generated.resources.Res

import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun StoreNearByCardItem(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(105.dp).clickable {

        }.padding(bottom = 5.dp)
    ) {
        Image(
            painter = painterResource(UiRes.Drawable.placeholder_dev_salon),
            modifier = Modifier
                .size(105.dp)
                .clip(RoundedCornerShape(size = 8.dp)),
            contentDescription = "Store item thumbnail",
            contentScale = ContentScale.Crop
        )
//        AsyncImage(
//            modifier = Modifier
//                .size(105.dp)
//                .clip(RoundedCornerShape(size = 8.dp)),
//            model = ImageRequest.Builder(LocalPlatformContext.current)
//                .data("https://static.wikia.nocookie.net/naruto/images/3/33/Naruto_Uzumaki_%28Parte_I_-_HD%29.png/revision/latest/scale-to-width-down/1200?cb=20160316113315&path-prefix=pt-br")
//                .crossfade(enable = true)
//                .build(),
//            contentDescription = "Store item thumbnail",
//            contentScale = ContentScale.Crop
//        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = "Sassoon Salon",
            fontSize = 12.sp,
            lineHeight = (8 * 1.3).sp,
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = "Hair salon",
            fontSize = 8.sp,
            lineHeight = (7.5 * 1.3).sp,
            fontWeight = FontWeight.Normal,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.secondary

        )
    }
}


@Preview(showBackground = true)
@Composable
private fun StoreNearByCardItemPreview() {
    IfoundTheme {
        StoreNearByCardItem()
    }
}
package com.artemissoftware.demeterhub.feature.shop.presentation.dashboard.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.error
import coil3.request.placeholder
import com.artemissoftware.demeterhub.R
import com.artemissoftware.demeterhub.core.designsystem.dimension
import com.artemissoftware.demeterhub.core.designsystem.shape
import com.artemissoftware.demeterhub.core.designsystem.spacing
import com.artemissoftware.demeterhub.feature.shop.domain.models.Shop
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme

@Composable
internal fun ShopCard(
    shop: Shop,
    modifier: Modifier = Modifier
) {

    val request = ImageRequest
        .Builder(LocalContext.current)
        .data(shop.imageUrl)
        .placeholder(R.drawable.ic_placeholder)
        .error(R.drawable.ic_error)
        .crossfade(true)
        .build()

    Box(
        modifier = modifier
            .size(MaterialTheme.dimension.shopCard)
            .shadow(elevation = 6.dp, shape = MaterialTheme.shape.shopCardShape)
            .clickable { /*onRestaurantSelected(restaurant)*/ }
            .background(Color.White)
            .clip(MaterialTheme.shape.shopCardShape)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = request,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
//                    .sharedElement(
//                        state = rememberSharedContentState(key = "image/${restaurant.id}"),
//                        animatedVisibilityScope = animatedVisibilityScope
//                    )
                ,
                contentScale = ContentScale.Crop
            )

            Detail(
                shop = shop,
                modifier = Modifier
                    .clickable { /*onRestaurantSelected(restaurant)*/ }
                    .fillMaxWidth()
                    .padding(MaterialTheme.spacing.spacing1_5)
            )
        }
        Rating(
            shop = shop,
            modifier = Modifier
                .align(TopStart)
                .padding(MaterialTheme.spacing.spacing1)
        )
    }
}

@Composable
private fun Detail(
    shop: Shop,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing1)
    ) {
        Text(
            text = shop.name,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
//                    modifier = Modifier.sharedElement(
//                        state = rememberSharedContentState(key = "title/${restaurant.id}"),
//                        animatedVisibilityScope = animatedVisibilityScope
//                    )
        )
        Row {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_delivery),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = MaterialTheme.spacing.spacing1)
                        .size(MaterialTheme.dimension.iconSizeSmall)
                )
                Text(
                    text = "Free Delivery",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.size(MaterialTheme.spacing.spacing1))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_timer),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = MaterialTheme.spacing.spacing1)
                        .size(MaterialTheme.dimension.iconSizeSmall)
                )
                Text(
                    text = "Free Delivery",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
private fun Rating(
    shop: Shop,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(MaterialTheme.shape.ratingPillShape)
            .background(Color.White)
            .padding(
                horizontal = MaterialTheme.spacing.spacing1,
                vertical = MaterialTheme.spacing.spacing1
            ),
            verticalAlignment = Alignment.CenterVertically,

    ) {
        Text(
            text = "4.5",
            style = MaterialTheme.typography.titleSmall,
        )
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.spacing0_5))

        Image(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            modifier = Modifier.size(MaterialTheme.dimension.iconSizeSmall),
        )

        Text(
            text = "(25)",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RatingPreview() {
    DemeterHubTheme {
        Rating(
            shop = Shop(
                address = "1007 Mountain Drive, Gotham City",
                categoryId = "1",
                createdAt = "2025-03-28T12:00:00Z",
                distance = 5.0,
                id = "batburger_001",
                imageUrl = "https://example.com/images/batburger.jpg",
                latitude = 40.7128,
                longitude = -74.0060,
                name = "Batburger",
                ownerId = "bruce_wayne"
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun DetailPreview() {
    DemeterHubTheme {
        Detail(
            shop = Shop(
                address = "1007 Mountain Drive, Gotham City",
                categoryId = "1",
                createdAt = "2025-03-28T12:00:00Z",
                distance = 5.0,
                id = "batburger_001",
                imageUrl = "https://example.com/images/batburger.jpg",
                latitude = 40.7128,
                longitude = -74.0060,
                name = "Batburger",
                ownerId = "bruce_wayne"
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun ShopCardPreview() {
    DemeterHubTheme {
        ShopCard(
            shop = Shop(
                address = "1007 Mountain Drive, Gotham City",
                categoryId = "1",
                createdAt = "2025-03-28T12:00:00Z",
                distance = 5.0,
                id = "batburger_001",
                imageUrl = "https://example.com/images/batburger.jpg",
                latitude = 40.7128,
                longitude = -74.0060,
                name = "Batburger",
                ownerId = "bruce_wayne"
            ),
            modifier = Modifier
        )
    }
}

package com.artemissoftware.demeterhub.feature.shop.presentation.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.artemissoftware.demeterhub.feature.shop.domain.models.Category
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme
import com.artemissoftware.demeterhub.ui.theme.Orange

@Composable
internal fun CategorySelector(
    category: Category,
    onCategorySelected: (Category) -> Unit,
    modifier: Modifier = Modifier
) {

    val request = ImageRequest
        .Builder(LocalContext.current)
        .data(category.imageUrl)
        .placeholder(R.drawable.ic_google)
        .error(R.drawable.ic_google)
        .crossfade(true)
        .build()

    Column(
        modifier = modifier
        .size(MaterialTheme.dimension.categoryPill)
//        .clickable { onCategorySelected(category) }
        .shadow(
            elevation = 16.dp,
            shape = MaterialTheme.shape.categoryPillShape,
            ambientColor = Color.Gray.copy(alpha = 0.8f),
            spotColor = Color.Gray.copy(alpha = 0.8f)
        )
        .background(color = Color.White)
        .clip(MaterialTheme.shape.categoryPillShape),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        AsyncImage(
            model = request,
            contentDescription = null,
            modifier = Modifier
                .size(MaterialTheme.dimension.categoryImagePill)
                .shadow(
                    elevation = 16.dp,
                    shape = MaterialTheme.shape.categoryPillImageShape,
                    ambientColor = Orange,
                    spotColor = Orange
                )
                .clip(MaterialTheme.shape.categoryPillImageShape)
            ,
            contentScale = ContentScale.Inside
        )
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.spacing1))
        Text(
            text = category.name,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun CategorySelectorPreview() {
    DemeterHubTheme {
        CategorySelector(
            category = Category(
                createdAt = "2009-09-09",
                id = "1",
                imageUrl = "",
                name = "Candy"
            ),
            onCategorySelected = {},
            modifier = Modifier
        )
    }
}
package com.artemissoftware.demeterhub.feature.shop.presentation.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.artemissoftware.demeterhub.core.designsystem.spacing
import com.artemissoftware.demeterhub.core.presentation.composables.scaffold.DHScaffold
import com.artemissoftware.demeterhub.feature.shop.domain.models.Category
import com.artemissoftware.demeterhub.feature.shop.domain.models.Shop
import com.artemissoftware.demeterhub.feature.shop.presentation.dashboard.composables.CategorySelector
import com.artemissoftware.demeterhub.feature.shop.presentation.dashboard.composables.ShopCard
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    DashboardContent(
        state = state,
        onEvent = viewModel::onTriggerEvent
    )
}

@Composable
private fun DashboardContent(
    state: DashboardState,
    onEvent: (DashboardEvent) -> Unit,
) {
    DHScaffold(
        content = {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing0_5)
                ) {
                    items(items = state.categories, key = { it.id }) { category ->
                        CategorySelector(
                            modifier = Modifier.padding(start = MaterialTheme.spacing.spacing2),
                            category = category,
                            onCategorySelected = {}
                        )
                    }
                }

                ShopList(
                    shops = state.shops
                )
            }
        }
    )
}

@Composable
private fun ShopList(
    shops: List<Shop>,
//    onRestaurantSelected: (Restaurant) -> Unit
) {
    Column {
        Row {
            Text(
                text = "Popular Restaurants",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = "View All",
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing0_5)
    ) {
        items(items = shops, key = { it.id }) { shop ->
            ShopCard(
                shop = shop,
                modifier = Modifier.padding(start = MaterialTheme.spacing.spacing2),
                //animatedVisibilityScope,
                //onRestaurantSelected
            )
        }
    }
}


//@OptIn(ExperimentalSharedTransitionApi::class)
//@Composable
//fun SharedTransitionScope.HomeScreen(
//    navController: NavController,
//    animatedVisibilityScope: AnimatedVisibilityScope,
//    viewModel: HomeViewModel = hiltViewModel(),
//) {
//
//    LaunchedEffect(Unit) {
//        viewModel.navigationEvent.collectLatest {
//            when (it) {
//                is HomeViewModel.HomeScreenNavigationEvents.NavigateToDetail -> {
//                    navController.navigate(RestaurantDetails(it.id, it.name, it.imageUrl))
//                }
//
//                else -> {
//
//                }
//            }
//        }
//    }
//
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        val uiState = viewModel.uiState.collectAsState()
//        when (uiState.value) {
//            is HomeViewModel.HomeScreenState.Loading -> {
//                Text(text = "Loading")
//            }
//
//            is HomeViewModel.HomeScreenState.Empty -> {
//                Text(text = "Empty")
//            }
//
//            is HomeViewModel.HomeScreenState.Success -> {
//                val categories = viewModel.categories
//                CategoriesList(categories = categories, onCategorySelected = {})
//
//                RestaurantList(
//                    restaurants = viewModel.restaurants,
//                    animatedVisibilityScope,
//                    onRestaurantSelected = {
//                        viewModel.onRestaurantSelected(it)
//                    })
//            }
//        }
//    }
//}
//

//@OptIn(ExperimentalSharedTransitionApi::class)
//@Composable
//fun SharedTransitionScope.RestaurantList(
//    restaurants: List<Restaurant>,
//    animatedVisibilityScope: AnimatedVisibilityScope,
//    onRestaurantSelected: (Restaurant) -> Unit
//) {
//    Column {
//        Row {
//            Text(
//                text = "Popular Restaurants",
//                style = Typography.titleMedium,
//                modifier = Modifier.padding(16.dp)
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            TextButton(onClick = { /*TODO*/ }) {
//                Text(text = "View All", style = Typography.bodySmall)
//            }
//        }
//    }
//    LazyRow {
//        items(restaurants) {
//            RestaurantItem(it, animatedVisibilityScope, onRestaurantSelected)
//        }
//    }
//}







@Preview
@Composable
private fun DashboardContentPreview() {
    DemeterHubTheme {
        DashboardContent(
            state = DashboardState(
                categories = listOf(
                    Category(
                        createdAt = "2009-09-09",
                        id = "1",
                        imageUrl = "",
                        name = "Candy"
                    ),
                    Category(
                        createdAt = "2009-09-09",
                        id = "2",
                        imageUrl = "",
                        name = "Candy"
                    ),
                    Category(
                        createdAt = "2009-09-09",
                        id = "3",
                        imageUrl = "",
                        name = "Candy"
                    )
                ),
                shops = listOf(
                    Shop(
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
                    Shop(
                        address = "21st and Broadway, Metropolis",
                        categoryId = "2",
                        createdAt = "2025-03-27T14:30:00Z",
                        distance = 2.3,
                        id = "bigbelly_002",
                        imageUrl = "https://example.com/images/bigbelly.jpg",
                        latitude = 38.9072,
                        longitude = -77.0369,
                        name = "Big Belly Burger",
                        ownerId = "lex_luthor"
                    ),
                    Shop(
                        address = "13 Central Avenue, Star City",
                        categoryId = "3",
                        createdAt = "2025-03-26T18:45:00Z",
                        distance = 1.0,
                        id = "sherwood_003",
                        imageUrl = "https://example.com/images/sherwood.jpg",
                        latitude = 45.4215,
                        longitude = -75.6972,
                        name = "Sherwood Cafe",
                        ownerId = "oliver_queen"
                    )
                )
            ),
            onEvent = {}
        )
    }
}
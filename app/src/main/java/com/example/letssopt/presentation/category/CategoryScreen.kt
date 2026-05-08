package com.example.letssopt.presentation.category

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.designsystem.component.Bar.WatchaBottomBar
import com.example.letssopt.designsystem.data.BottomBarTab
import com.example.letssopt.designsystem.data.icons
import com.example.letssopt.presentation.main.routeToTab
import com.example.letssopt.presentation.navigation.Category
import com.example.letssopt.presentation.navigation.Folder
import com.example.letssopt.presentation.navigation.Main
import com.example.letssopt.presentation.navigation.Search
import com.example.letssopt.presentation.navigation.Webtoon
import kotlinx.collections.immutable.toImmutableList

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val currentTab = routeToTab(currentRoute)

    Scaffold(
        bottomBar = {
            WatchaBottomBar(
                items = icons.toImmutableList(),
                selectedTab = currentTab,
                onItemClick = { tab ->
                    if (tab != currentTab) {
                        navController.navigate(
                            tab.route
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Text(
            text = "Category Tab",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryScreenPreview() {
    CategoryScreen(
        navController = rememberNavController()
    )
}
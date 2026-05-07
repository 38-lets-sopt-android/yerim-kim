package com.example.letssopt.presentation.folder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.designsystem.component.Bar.WatchaBottomBar
import com.example.letssopt.designsystem.component.Folder.WatchaFolders
import com.example.letssopt.designsystem.component.Text.WatchaSemiTitle
import com.example.letssopt.designsystem.data.BottomBarTab
import com.example.letssopt.designsystem.data.FolderImages
import com.example.letssopt.designsystem.data.icons
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.presentation.main.routeToTab
import com.example.letssopt.presentation.navigation.Category
import com.example.letssopt.presentation.navigation.Folder
import com.example.letssopt.presentation.navigation.Main
import com.example.letssopt.presentation.navigation.Search
import com.example.letssopt.presentation.navigation.Webtoon
import kotlinx.collections.immutable.toImmutableList

@Composable
fun FolderScreen(
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
                            when (tab) {
                                BottomBarTab.MAIN -> Main
                                BottomBarTab.CATEGORY -> Category
                                BottomBarTab.WEBTOON -> Webtoon
                                BottomBarTab.SEARCH -> Search
                                BottomBarTab.FOLDER -> Folder
                            }
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Background)
                    .padding(16.dp)
            ) {
                WatchaSemiTitle(
                    text = "찜한 목록",
                    modifier = Modifier
                        .padding(
                            top = 70.dp,
                            bottom = 40.dp
                        )
                )

                WatchaFolders(
                    items = FolderImages
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FolderScreenPreview() {
    FolderScreen(navController = rememberNavController())
}
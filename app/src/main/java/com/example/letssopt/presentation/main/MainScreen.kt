package com.example.letssopt.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.R
import com.example.letssopt.designsystem.component.Banner.WatchaBanner
import com.example.letssopt.designsystem.component.Bar.WatchaBottomBar
import com.example.letssopt.designsystem.component.Bar.WatchaMainTopBar
import com.example.letssopt.designsystem.component.Content.WatchaContents
import com.example.letssopt.designsystem.component.Party.WatchaPartyCards
import com.example.letssopt.designsystem.component.Text.WatchaSemiTitle
import com.example.letssopt.designsystem.component.Text.WatchaSubTitleRow
import com.example.letssopt.designsystem.data.BottomBarTab
import com.example.letssopt.designsystem.data.icons
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.TextPrimary
import com.example.letssopt.presentation.navigation.Category
import com.example.letssopt.presentation.navigation.Folder
import com.example.letssopt.presentation.navigation.Main
import com.example.letssopt.presentation.navigation.Search
import com.example.letssopt.presentation.navigation.Webtoon
import kotlinx.collections.immutable.toImmutableList

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MainViewModel = viewModel()
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
            modifier = modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Background)
                    .padding(top = 10.dp)
                    .verticalScroll(rememberScrollState()), // 스크롤
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                WatchaMainTopBar(
                    icons = listOf(
                        R.drawable.ic_top_watch_24,
                        R.drawable.ic_top_notice_24,
                        R.drawable.ic_top_profile_24
                    ),
                    onIconClick = { index -> },
                    modifier = Modifier
                        .align(Alignment.End)
                )

                WatchaSemiTitle(
                    text = "방금 막 도착한 신상 컨텐츠",
                    modifier = Modifier.padding(start = 19.dp)
                )

                Text(
                    text = "예능부터 드라마까지!",
                    fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
                    fontWeight = FontWeight(600),
                    fontSize = 18.sp,
                    color = Color(0xFFBABAC1),
                    modifier = Modifier.padding(
                        start = 19.dp,
                        bottom = 20.dp
                    )
                )

                WatchaBanner(
                    images = viewModel.banners
                )

                Icon(
                    painter = painterResource(id = R.drawable.img_watgorism),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.padding(
                        start = 19.dp,
                        top = 20.dp,
                        bottom = 5.dp
                    )
                )

                WatchaSubTitleRow(
                    text = "예능부터 드라마까지!",
                    moreInfo = "더보기",
                    color = Color(0xFFBABAC1),
                    modifier = Modifier.padding(
                        start = 19.dp,
                        bottom = 10.dp,
                        end = 19.dp
                    )
                )

                WatchaContents(
                    images = viewModel.contents
                )

                WatchaSubTitleRow(
                    text = "공개 예정 콘텐츠",
                    moreInfo = "더보기",
                    color = TextPrimary,
                    modifier = Modifier.padding(
                        top = 20.dp,
                        bottom = 10.dp,
                        start = 19.dp,
                        end = 19.dp
                    )
                        .align(Alignment.CenterHorizontally)
                )

                WatchaContents(
                    images = viewModel.contents
                )

                WatchaSemiTitle(
                    text = "왓챠 파티",
                    modifier = Modifier.padding(
                        start = 19.dp,
                        top = 20.dp,
                        bottom = 10.dp
                    )
                )

                WatchaPartyCards(
                    items = viewModel.parties,
                    modifier = Modifier.padding(start = 19.dp)
                )

                Spacer(modifier = Modifier.height(0.dp))
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    LETSSOPTTheme {
        MainScreen(
            navController = rememberNavController()
        )
    }
}

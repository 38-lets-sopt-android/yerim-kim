package com.example.letssopt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.example.letssopt.R
import com.example.letssopt.designsystem.component.WatchaBanner
import com.example.letssopt.designsystem.component.WatchaBottomBar
import com.example.letssopt.designsystem.component.WatchaContents
import com.example.letssopt.designsystem.component.WatchaMainTopBar
import com.example.letssopt.designsystem.component.WatchaPartyCards
import com.example.letssopt.designsystem.component.WatchaSemiTitle
import com.example.letssopt.designsystem.data.bannerImages
import com.example.letssopt.designsystem.data.contentImages
import com.example.letssopt.designsystem.data.icons
import com.example.letssopt.designsystem.data.partyImages
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.designsystem.theme.LETSSOPTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = {
            WatchaBottomBar(
                items = icons,
                onItemClick = { }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Background)
                    .padding(start = 8.dp)
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
                    modifier = Modifier
                )

                Text(
                    text = "예능부터 드라마까지!",
                    fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                    fontWeight = FontWeight(600),
                    fontSize = 18.sp,
                    color = Color(0xFFBABAC1),
                    modifier = modifier
                )

                WatchaBanner(
                    images = bannerImages
                )

                Icon(
                    painter = painterResource(id = R.drawable.img_watgorism),
                    contentDescription = null,
                    tint = Color.Unspecified
                )

                WatchaContents(
                    images = contentImages
                )

                WatchaSemiTitle(
                    text = "공개 예정 콘텐츠",
                    modifier = Modifier
                )

                WatchaContents(
                    images = contentImages
                )

                WatchaSemiTitle(
                    text = "왓챠 파티",
                    modifier = Modifier
                )

                WatchaPartyCards(
                    items = partyImages,
                    modifier = Modifier
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
        MainScreen()
    }
}
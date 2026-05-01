package com.example.letssopt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.example.letssopt.designsystem.component.Bar.WatchaBottomBar
import com.example.letssopt.designsystem.component.Folder.WatchaFolders
import com.example.letssopt.designsystem.component.Text.WatchaSemiTitle
import com.example.letssopt.designsystem.data.FolderImages
import com.example.letssopt.designsystem.data.icons
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.presentation.ui.theme.LETSSOPTTheme

class FolderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FolderScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FolderScreen(modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = {
            WatchaBottomBar(
                items = icons,
                onItemClick = { }
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
    LETSSOPTTheme {
        FolderScreen()
    }
}
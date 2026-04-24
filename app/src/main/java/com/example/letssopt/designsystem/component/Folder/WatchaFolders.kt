package com.example.letssopt.designsystem.component.Folder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.designsystem.data.ForderItem
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.designsystem.theme.LETSSOPTTheme

@Composable
fun WatchaFolders(
    items: List<ForderItem>,
    modifier: Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        items(items) { item ->
            WatchaFolder(
                item = item,
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WatchaFoldersPreview() {
    LETSSOPTTheme {

        val dummyItems = listOf(
            ForderItem(
                image = R.drawable.img_content1,
                icon = R.drawable.ic_party_notice_35
            ),
            ForderItem(
                image = R.drawable.img_content2,
                icon = R.drawable.ic_party_notice_35
            ),
            ForderItem(
                image = R.drawable.img_content3,
                icon = R.drawable.ic_party_notice_35
            ),
            ForderItem(
                image = R.drawable.img_content1,
                icon = R.drawable.ic_party_notice_35
            )
        )

        WatchaFolders(
            items = dummyItems,
            modifier = Modifier
        )
    }
}
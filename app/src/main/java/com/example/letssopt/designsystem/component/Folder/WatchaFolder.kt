package com.example.letssopt.designsystem.component.Folder

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.designsystem.data.ForderItem
import com.example.letssopt.designsystem.theme.LETSSOPTTheme

@Composable
fun WatchaFolder(
    item: ForderItem,
    modifier: Modifier
) {
    Column (
        modifier = Modifier
            .background(Color.Transparent)
            .padding(
                top = 10.dp,
                bottom = 10.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(150.dp),
            contentScale = ContentScale.Crop
        )

        Icon(
            painter = painterResource(R.drawable.ic_cancel_24),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WatchaFolderPreview() {
    LETSSOPTTheme {
        WatchaFolder(
            item = ForderItem(
                image = R.drawable.img_content1,
                icon = R.drawable.ic_party_notice_35
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}
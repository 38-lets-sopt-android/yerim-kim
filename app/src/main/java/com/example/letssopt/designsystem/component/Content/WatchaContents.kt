package com.example.letssopt.designsystem.component.Content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.designsystem.theme.LETSSOPTTheme

@Composable
fun WatchaContents(
    images: List<Int>,
    modifier: Modifier = Modifier
) {
    val startIndex = Int.MAX_VALUE / 2
    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = startIndex - startIndex % images.size
    )

    LazyRow(
        state = listState,
        modifier = modifier
    ) {
        items(
            count = Int.MAX_VALUE
        ) { index ->
            Image(
                painter = painterResource(id = images[index % images.size]),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(width = 100.dp, height = 150.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WatchaContentsPreview() {
    LETSSOPTTheme {
        WatchaContents(
            images = listOf(
                R.drawable.img_content1,
                R.drawable.img_content2,
                R.drawable.img_content3
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}
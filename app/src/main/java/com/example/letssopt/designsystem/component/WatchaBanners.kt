package com.example.letssopt.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun WatchaBanner(
    images: List<Int>,
    modifier: Modifier = Modifier
) {
    val startIndex = Int.MAX_VALUE / 2
    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = startIndex - startIndex % images.size,
        initialFirstVisibleItemScrollOffset = 700
    )

    LazyRow(
        state = listState,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            count = Int.MAX_VALUE
        ) { index ->
            Image(
                painter = painterResource(id = images[index % images.size]),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(width = 280.dp, height = 160.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}
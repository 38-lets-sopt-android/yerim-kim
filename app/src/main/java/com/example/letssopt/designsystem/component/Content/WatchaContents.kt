package com.example.letssopt.designsystem.component.Content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.letssopt.designsystem.theme.Background
import kotlinx.collections.immutable.ImmutableList

@Composable
fun WatchaContents(
    images: ImmutableList<Int>,
    modifier: Modifier = Modifier
) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
    ) {
        items(images) { image ->
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp, 150.dp)
                    .background(Background),
                contentScale = ContentScale.Crop
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun WatchaContentsPreview() {
//    LETSSOPTTheme {
//        WatchaContents(
//            images = listOf(
//                R.drawable.img_content1,
//                R.drawable.img_content2,
//                R.drawable.img_content3
//            ),
//            modifier = Modifier.padding(16.dp)
//        )
//    }
//}
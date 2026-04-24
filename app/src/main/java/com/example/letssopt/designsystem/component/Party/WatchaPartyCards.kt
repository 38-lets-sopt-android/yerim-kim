package com.example.letssopt.designsystem.component.Party

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.designsystem.data.partyImages
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.designsystem.theme.LETSSOPTTheme

data class PartyItem(
    val image: Int,
    val time: String,
    val tag: String
)

@Composable
fun WatchaPartyCards(
    items: List<PartyItem>,
    modifier: Modifier = Modifier
) {
    if (items.isEmpty()) return

    val startIndex = Int.MAX_VALUE / 2
    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = startIndex - startIndex % items.size
    )

    LazyRow(
        state = listState,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
    ) {
        items(
            count = Int.MAX_VALUE
        ) { index ->
            WatchaPartyCard(
                item = items[index % items.size],
                modifier = Modifier.background(Background)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WatchaContentRowPreview() {
    LETSSOPTTheme {
        val dummyItems = partyImages

        WatchaPartyCards(
            items = dummyItems,
            modifier = Modifier
        )
    }
}
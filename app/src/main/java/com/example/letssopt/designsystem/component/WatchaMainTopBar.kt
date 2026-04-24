package com.example.letssopt.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WatchaMainTopBar(
    icons: List<Int>,
    onIconClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(top = 23.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ){
        icons.forEachIndexed { index, icon ->
            WatchaTopIconButton(
                iconRes = icon,
                onClick = { onIconClick(index) },
                modifier = Modifier.padding(end = 14.dp)
            )
        }
    }
}
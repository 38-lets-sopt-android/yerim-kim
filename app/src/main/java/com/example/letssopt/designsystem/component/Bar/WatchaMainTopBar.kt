package com.example.letssopt.designsystem.component.Bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.letssopt.designsystem.component.Button.WatchaTopIconButton
import com.example.letssopt.designsystem.theme.TextPrimary

@Composable
fun WatchaMainTopBar(
    icons: List<Int>,
    onIconClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Row(
            modifier = modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ){
            icons.forEachIndexed { index, icon ->
                WatchaTopIconButton(
                    iconRes = icon,
                    onClick = { onIconClick(index) },
                    color = TextPrimary,
                    modifier = Modifier.padding(end = 14.dp)
                )
            }
        }
    }
}
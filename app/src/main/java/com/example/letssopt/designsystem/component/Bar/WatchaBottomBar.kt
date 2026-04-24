package com.example.letssopt.designsystem.component.Bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.designsystem.component.Button.WatchaTopIconButton
import com.example.letssopt.designsystem.data.BottomBarIcon
import com.example.letssopt.designsystem.data.icons
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.designsystem.theme.Disabled
import com.example.letssopt.designsystem.theme.LETSSOPTTheme

@Composable
fun WatchaBottomBar(
    items: List<BottomBarIcon>,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        containerColor = Background,
        contentColor = Background,
        modifier = modifier
            .fillMaxWidth()
            .background(Background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Background),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    WatchaTopIconButton(
                        iconRes = item.icon,
                        onClick = { onItemClick(index) }
                    )
                    Text(
                        text = item.text,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                        fontWeight = FontWeight(400),
                        color = Disabled,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WatchaBottomBarPreview() {
    LETSSOPTTheme {
        WatchaBottomBar(
            items = icons,
            onItemClick = {_ ->},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

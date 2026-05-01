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
import com.example.letssopt.designsystem.data.BottomBarTab
import com.example.letssopt.designsystem.data.icons
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.designsystem.theme.Disabled
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.TextPrimary

@Composable
fun WatchaBottomBar(
    items: List<BottomBarTab>,
    selectedTab: BottomBarTab,
    onItemClick: (BottomBarTab) -> Unit,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        containerColor = Background,
        contentColor = TextPrimary,
        modifier = modifier
            .fillMaxWidth()
            .background(Background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Background),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                val isSelected = item == selectedTab

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    WatchaTopIconButton(
                        iconRes = item.icon,
                        onClick = { onItemClick(item) },
                        color = if (isSelected) TextPrimary else Disabled
                    )

                    Text(
                        text = item.label,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                        fontWeight = FontWeight(400),
                        color = if (isSelected) TextPrimary else Disabled,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun WatchaBottomBarPreview() {
    LETSSOPTTheme {
        WatchaBottomBar(
            items = icons,
            selectedTab = BottomBarTab.MAIN,
            onItemClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

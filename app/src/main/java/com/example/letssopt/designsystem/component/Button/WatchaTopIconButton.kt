package com.example.letssopt.designsystem.component.Button

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun WatchaTopIconButton(
    iconRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(24.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null, // 설명 텍스트
            tint = Color.Unspecified
        )
    }
}
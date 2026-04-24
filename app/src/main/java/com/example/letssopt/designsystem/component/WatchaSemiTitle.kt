package com.example.letssopt.designsystem.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.letssopt.designsystem.theme.TextPrimary

@Composable
fun WatchaSemiTitle(
    text: String,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        fontFamily = FontFamily(Font(com.example.letssopt.R.font.pretendard_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = TextPrimary,
        modifier = modifier
    )
}

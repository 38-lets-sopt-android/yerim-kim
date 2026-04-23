package com.example.letssopt.designsystem.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.letssopt.designsystem.theme.TextSecondary

@Composable
fun WatchaFormField(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontFamily = FontFamily(Font(com.example.letssopt.R.font.pretendard_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = TextSecondary,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun WatchaFormFieldPreview() {
    WatchaFormField(text = "이메일")
}
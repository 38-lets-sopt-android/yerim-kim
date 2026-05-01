package com.example.letssopt.designsystem.component.Text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.designsystem.theme.TextSecondary

@Composable
fun WatchaSubTitleRow(
    text: String,
    moreInfo: String,
    color: Color,
    modifier: Modifier
){
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
            fontWeight = FontWeight(600),
            fontSize = 20.sp,
            color = color,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = moreInfo,
            fontFamily = FontFamily(Font(com.example.letssopt.R.font.pretendard_regular)),
            fontWeight = FontWeight(300),
            fontSize = 12.sp,
            color = TextSecondary,
            modifier = Modifier.align(Alignment.Bottom)
        )
    }
}

@Preview
@Composable
private fun WatchaSubTitleRowPriview() {
    WatchaSubTitleRow(
        text = "여기!",
        moreInfo = "더보기",
        color = Color.White,
        modifier = Modifier
    )
}
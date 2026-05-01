package com.example.letssopt.designsystem.component.Party

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.designsystem.theme.PrimaryRed
import com.example.letssopt.designsystem.theme.Surface
import com.example.letssopt.designsystem.theme.TextPrimary

@Composable
fun WatchaPartyCard(
    item: PartyItem
) {
    Box (
        modifier = Modifier
            .width(196.dp)
            .height(185.dp)
            .background(Surface)
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            modifier = Modifier
                .width(196.dp)
                .height(139.dp),
            contentScale = ContentScale.Crop
        )

        Icon(
            painter = painterResource(R.drawable.ic_party_notice_35),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        )

        Column(
            modifier = Modifier
                .padding(
                    top = 144.dp,
                    start = 8.dp
                )
        ) {
            Text(
                text = item.time,
                color = PrimaryRed,
                fontSize = 12.sp,
                lineHeight = 12.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontWeight = FontWeight(600),
            )
            Text(
                text = item.tag,
                color = TextPrimary,
                fontSize = 12.sp,
                lineHeight = 12.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun BannerCardPreview() {
//    LETSSOPTTheme {
//        WatchaPartyCard(
//            item = PartyItem(
//                image = R.drawable.img_party1,
//                time = "오늘 21:13에 시작",
//                tag = "#왕과사는 남자"
//            ),
//            modifier = Modifier
//        )
//    }
//}
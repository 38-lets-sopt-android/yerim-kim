package com.example.letssopt.designsystem.data

import com.example.letssopt.R

data class BottomBarIcon (
    val icon: Int,
    val text: String
)

val icons = listOf(
    BottomBarIcon(
        icon = R.drawable.ic_bottom_main_24,
        text = "메인"
    ),
    BottomBarIcon(
        icon = R.drawable.ic_bottom_category_24,
        text = "개별 구매"
    ),
    BottomBarIcon(
        icon = R.drawable.ic_bottom_webtoon_24,
        text = "웹툰"
    ),
    BottomBarIcon(
        icon = R.drawable.ic_bottom_search_24,
        text = "찾기"
    ),
    BottomBarIcon(
        icon = R.drawable.ic_bottom_folder_24,
        text = "보관함"
    )
)
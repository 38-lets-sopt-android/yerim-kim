package com.example.letssopt.designsystem.data

import com.example.letssopt.R

enum class BottomBarTab(
    val icon: Int,
    val label: String
) {
    MAIN(R.drawable.ic_bottom_main_24, "메인"),
    CATEGORY(R.drawable.ic_bottom_category_24, "개별 구매"),
    WEBTOON(R.drawable.ic_bottom_webtoon_24, "웹툰"),
    SEARCH(R.drawable.ic_bottom_search_24, "찾기"),
    FOLDER(R.drawable.ic_bottom_folder_24, "보관함")
}

val icons = listOf(
    BottomBarTab.MAIN,
    BottomBarTab.CATEGORY,
    BottomBarTab.WEBTOON,
    BottomBarTab.SEARCH,
    BottomBarTab.FOLDER,
)
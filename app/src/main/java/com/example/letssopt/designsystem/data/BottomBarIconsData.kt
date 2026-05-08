package com.example.letssopt.designsystem.data

import com.example.letssopt.R
import com.example.letssopt.presentation.navigation.Category
import com.example.letssopt.presentation.navigation.Folder
import com.example.letssopt.presentation.navigation.Main
import com.example.letssopt.presentation.navigation.Search
import com.example.letssopt.presentation.navigation.Webtoon

enum class BottomBarTab(
    val icon: Int,
    val label: String,
    val route: Any
) {
    MAIN(R.drawable.ic_bottom_main_24, "메인", Main),
    CATEGORY(R.drawable.ic_bottom_category_24, "개별 구매", Category),
    WEBTOON(R.drawable.ic_bottom_webtoon_24, "웹툰", Webtoon),
    SEARCH(R.drawable.ic_bottom_search_24, "찾기", Search),
    FOLDER(R.drawable.ic_bottom_folder_24, "보관함", Folder)
}

val icons = listOf(
    BottomBarTab.MAIN,
    BottomBarTab.CATEGORY,
    BottomBarTab.WEBTOON,
    BottomBarTab.SEARCH,
    BottomBarTab.FOLDER,
)
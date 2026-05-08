package com.example.letssopt.presentation.main

import com.example.letssopt.designsystem.data.BottomBarTab

data class BannerItem(
    val image: Int
)

data class ContentItem(
    val image: Int
)

data class PartyItem(
    val image: Int,
    val time: String,
    val tag: String
)

fun routeToTab(route: String?): BottomBarTab = when {
    route?.contains("Main") == true -> BottomBarTab.MAIN
    route?.contains("Category") == true -> BottomBarTab.CATEGORY
    route?.contains("Webtoon") == true -> BottomBarTab.WEBTOON
    route?.contains("Search") == true -> BottomBarTab.SEARCH
    route?.contains("Folder") == true -> BottomBarTab.FOLDER
    else -> BottomBarTab.MAIN
}
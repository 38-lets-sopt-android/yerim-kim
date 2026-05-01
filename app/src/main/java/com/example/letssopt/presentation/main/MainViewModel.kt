package com.example.letssopt.presentation.main

import androidx.lifecycle.ViewModel
import com.example.letssopt.R
import com.example.letssopt.designsystem.component.Party.PartyItem

class MainViewModel : ViewModel() {

    private val _banners = listOf(
        BannerItem(R.drawable.img_banner1),
        BannerItem(R.drawable.img_banner2),
        BannerItem(R.drawable.img_banner3),
        BannerItem(R.drawable.img_banner1),
        BannerItem(R.drawable.img_banner2),
        BannerItem(R.drawable.img_banner3)
    )
    val banners get() = _banners

    private val _contents = listOf(
        ContentItem(R.drawable.img_content1),
        ContentItem(R.drawable.img_content2),
        ContentItem(R.drawable.img_content3),
        ContentItem(R.drawable.img_content1),
        ContentItem(R.drawable.img_content2),
        ContentItem(R.drawable.img_content3)
    )
    val contents get() = _contents

    private val _parties = listOf(
        PartyItem(
            image = R.drawable.img_party1,
            time = "오늘 21:13에 시작",
            tag = "#왕과사는남자"
        ),
        PartyItem(
            image = R.drawable.img_party2,
            time = "오늘 22:22에 시작",
            tag = "#파묘"
        )
    )
    val parties get() = _parties
}
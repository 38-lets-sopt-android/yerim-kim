package com.example.letssopt.designsystem.data

import com.example.letssopt.R

data class ForderItem (
    val image: Int,
    val icon: Int
)

val FolderImages = listOf(
    ForderItem(
        image = R.drawable.img_content1,
        icon = R.drawable.ic_cancel_24
    ),
    ForderItem(
        image = R.drawable.img_content2,
        icon = R.drawable.ic_cancel_24
    ),ForderItem(
        image = R.drawable.img_content3,
        icon = R.drawable.ic_cancel_24
    ),
    ForderItem(
        image = R.drawable.img_content1,
        icon = R.drawable.ic_cancel_24
    )
)
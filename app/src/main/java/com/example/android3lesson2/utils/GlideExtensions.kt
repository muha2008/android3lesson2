package com.example.android3lesson2.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.android3lesson2.R

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        // до загруски стоит
       // .placeholder(R.drawable.fallback_image)

        //когда не загрузился изображение будет показывать это
        .fallback(R.drawable.ic_launcher_background)

        // это если призошол ашибка при загрузки
        //.error(R.drawable.img)
        .into(this)
}
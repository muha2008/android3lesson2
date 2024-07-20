package com.example.android3homework2mc5.models

import com.google.gson.annotations.SerializedName

data class Photos(
    @SerializedName("photo")
    val photo: List<Photo>
)

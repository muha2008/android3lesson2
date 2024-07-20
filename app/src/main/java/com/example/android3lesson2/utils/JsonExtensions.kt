package com.example.android3homework2mc5.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun Context.readJsonFromAssets(fileName: String): String {
    return this.assets.open(fileName).bufferedReader().use { it.readText() }
}

//я тут добавил inline и reified в жинерик типа Т я добавил reified
inline fun <reified T> parseJsonToModel(jsonString: String): T {
    val gson = Gson()
    return gson.fromJson(jsonString, object : TypeToken<T>() {}.type)
}
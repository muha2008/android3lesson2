package com.example.android3homework2mc5.ui.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android3homework2mc5.models.Photo
import com.example.android3homework2mc5.models.PhotosResponse
import com.example.android3homework2mc5.utils.parseJsonToModel
import com.example.android3homework2mc5.utils.readJsonFromAssets

class HomeViewModel(private val application: Application) : AndroidViewModel(application) {

    private val _photo = MutableLiveData<Photo>()
    val photo: LiveData<Photo> get() = _photo

    fun getPhotos(): PhotosResponse {
        val photosJsonString = application.applicationContext.readJsonFromAssets("photos.json")
        val response = parseJsonToModel<PhotosResponse>(photosJsonString)
        return response
    }
    fun setPhoto(photo: Photo) {
        _photo.value = photo
    }

    //это он крей начала создание
    override fun onCleared() {
        super.onCleared()
    }
}
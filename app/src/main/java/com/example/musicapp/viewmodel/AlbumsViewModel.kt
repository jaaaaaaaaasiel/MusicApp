package com.example.musicapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicapp.models.Album
import com.example.musicapp.services.AlbumService
import com.example.musicapp.viewmodel.RetrofitInstance.retrofit
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AlbumsViewModel: ViewModel() {
    var albums by mutableStateOf<List<Album>>(emptyList())
    var loading by mutableStateOf(true)

    fun loadAblbums(){
        viewModelScope.launch {
            try {
                val service = retrofit.create(AlbumService::class.java)
                val result = async {
                    service.getAllAlbums()
                }
                albums = result.await()
                loading = false
            } catch (e: Exception) {
                loading = false
                Log.e("AlbumsViewModel", e.toString())

            }
        }
    }


}
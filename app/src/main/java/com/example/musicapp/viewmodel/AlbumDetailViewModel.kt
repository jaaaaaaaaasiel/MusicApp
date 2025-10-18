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

class AlbumDetailViewModel: ViewModel() {
    var album by mutableStateOf<Album?>(null)
    var loading by mutableStateOf(true)

    fun loadAlbum(id: String){
        viewModelScope.launch {
            try {
                val service = retrofit.create(AlbumService::class.java)
                val result = async {
                    service.getAlbumById(id)
                }
                album = result.await()
            } catch (e: Exception) {
               loading = false
               Log.e("AlbumDetailViewModel", e.toString())
            }
        }
    }

}
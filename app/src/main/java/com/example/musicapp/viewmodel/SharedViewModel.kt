package com.example.musicapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    var selectedAlbumId by mutableStateOf<String?>(null)
        private set
    fun selectAlbum(albumId: String) {
        selectedAlbumId = albumId
    }
}
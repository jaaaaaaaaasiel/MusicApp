package com.example.musicapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    val title: String,
    val artist: String,
    val description: String,
    val image: String,
    val id: String
) : Parcelable


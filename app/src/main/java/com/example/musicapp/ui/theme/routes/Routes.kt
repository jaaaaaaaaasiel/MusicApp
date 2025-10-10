package com.example.musicapp.ui.theme.routes

import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

@Serializable
data class AlbumDetailScreenRoute(val id: String)
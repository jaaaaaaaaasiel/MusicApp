package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.musicapp.models.Album
import com.example.musicapp.ui.theme.BackDeg1
import com.example.musicapp.ui.theme.BackDeg5

@Composable
fun AlbumCard(album: Album){
    Box(modifier = Modifier
        .height(125.dp)
        .width(120.dp),
        contentAlignment = Alignment.Bottom as Alignment){
        AsyncImage(
            model = album.image,
            contentDescription = album.title,
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.horizontalGradient(listOf(BackDeg1, BackDeg5))),
            contentScale = ContentScale.Crop
        )
        Row(modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth()
            .background(Color.Transparent.copy(alpha = 0.68f))
        ) {
            Column {
                Text(album.title)
                Text(album.artist)
            }
            Icon(Icons.Default.PlayArrow,"Listen Now!")
        }
    }
}
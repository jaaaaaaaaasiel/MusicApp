package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.composables.PlayCircle
import com.example.musicapp.models.Album
import com.example.musicapp.ui.theme.BackDeg1
import com.example.musicapp.ui.theme.BackDeg5
import com.example.musicapp.ui.theme.Hueso

@Composable
fun AlbumCard(
    album: Album,
    onClick: () -> Unit
    ){
    Box(modifier = Modifier
        .padding(start = 12.dp, end = 12.dp, bottom = 7.dp)
        .height(145.dp)
        .width(155.dp)
        .clip(RoundedCornerShape(14.dp))
        .clickable(enabled = true, onClick = onClick),
        contentAlignment = Alignment.BottomEnd
        ){
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
            .clip(RoundedCornerShape(7.dp))
            .background(Color.Transparent.copy(alpha = 0.3f))
            .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = album.title,
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 13.sp,
                    color = Hueso
                )
                Text(
                    text = album.artist,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Light,
                    color = Hueso
                )
            }
            PlayCircle(Modifier.size(20.dp), tint = Hueso)
        }
    }
}
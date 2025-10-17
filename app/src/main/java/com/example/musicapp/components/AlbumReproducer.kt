package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.PauseCircle
import com.composables.PlayCircle
import com.example.musicapp.models.Album
import com.example.musicapp.ui.theme.Hueso

@Composable
fun AlbumReproducer(album: Album?){
    Column(
        modifier = Modifier
            .height(100.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Transparent.copy(0.2f))
            .padding(5.dp)
    ) {
        Text(
            text = album?.title ?: "No selected album",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 5.dp),
            color = Hueso
        )
        Text(
            text = album?.artist ?: "No selected artist",
            style = MaterialTheme.typography.titleSmall,
            fontSize = 10.sp,
            modifier = Modifier.padding(start = 5.dp),
            color = Hueso.copy(alpha = 0.7f)

        )
        Row(
            Modifier
                .padding(top = 10.dp)
        ) {
            PlayCircle(Modifier.size(40.dp), tint = Hueso)
            PauseCircle(Modifier.size(40.dp), tint = Hueso)
        }


    }
}
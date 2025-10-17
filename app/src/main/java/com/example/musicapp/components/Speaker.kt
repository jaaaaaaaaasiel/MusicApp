package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.composables.PlayCircle
import com.example.musicapp.models.Album
import com.example.musicapp.ui.theme.BackDeg4
import com.example.musicapp.ui.theme.BackDeg5
import com.example.musicapp.ui.theme.Hueso

@Composable
fun Speaker(
    selectedAlbum: Album,
    onClick: () -> Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
        .background(Brush.linearGradient(listOf(BackDeg4, BackDeg5),
            start = Offset(0f,0f ),
            end = Offset(0f, 150f))
        )
        .padding(7.dp)
        .clickable(enabled = true, onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = selectedAlbum.image,
            contentDescription = selectedAlbum.title,
            modifier = Modifier
                .padding(start = 2.2.dp)
                .width(59.dp)
                .height(59.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
        )
        Column(Modifier
            .padding(start = 7.dp)
            .weight(1f)){
            Text(
                text= selectedAlbum.title,
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Hueso)
            Text(
                text = selectedAlbum.artist,
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 12.sp,
                color = Hueso.copy(alpha = 0.85f))
        }
        Icon(
            PlayCircle,
            "Play",
            tint = Hueso,
            modifier = Modifier
                .padding(end = 7.dp)
                .size(35.dp)
        )
    }
}
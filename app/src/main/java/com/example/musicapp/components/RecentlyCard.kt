package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.musicapp.models.Album
import com.example.musicapp.ui.theme.Hueso

@Composable
fun RecentlyCard(
    album: Album,
    onClick: () -> Unit
){
    Row(modifier = Modifier
        .padding(9.dp)
        .fillMaxWidth()
        .height(63.dp)
        .clip(RoundedCornerShape(14.dp))
        .border(
            width = 0.5.dp,
            color = Color.White.copy(alpha = 0.6f),
            shape = RoundedCornerShape(14.dp)
        )
        .shadow(
            elevation = 2.dp,
            shape = RoundedCornerShape(14.dp),
            ambientColor = Color.White)
        .background(Color.Transparent.copy(alpha = 0.27f))
        .padding(7.dp)
        .clickable(enabled = true, onClick= onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = album.image,
            contentDescription = album.title,
            modifier = Modifier
                .padding(start = 3.dp)
                .width(54.dp)
                .height(54.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(Color.Black),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier
            .padding(start = 10.dp)
            .weight(1f)
        ) {
            Text(
                text = album.title,
                style = MaterialTheme.typography.labelLarge,
                color = Hueso.copy(alpha = 0.9f)
            )
            Text(
                text= "${album.artist}   •   Popular Song",
                style = MaterialTheme.typography.labelSmall,
                color = Hueso.copy(alpha = 0.7f)
            )
        }
        Icon(
            imageVector = Icons.Default.MoreVert,
            null,
            tint = Hueso)

    }
}
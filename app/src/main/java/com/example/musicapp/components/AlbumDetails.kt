package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.musicapp.models.Album
import com.example.musicapp.ui.theme.BackDeg2
import com.example.musicapp.ui.theme.BackDeg4
import com.example.musicapp.ui.theme.BackDeg5
import com.example.musicapp.ui.theme.Hueso

@Composable
fun ALbumDetails(album: Album?){
    Column(Modifier
        .padding(horizontal = 10.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(16.dp))
        .border(
            width = 1.2.dp,
            brush = Brush.horizontalGradient(listOf(BackDeg5, BackDeg4)),
            shape = RoundedCornerShape(16.dp)
        )
        .background(Color.Transparent.copy(0.2f))
        .padding(10.dp)
    ) {
        Text(
            text = "About Album",
            style = MaterialTheme.typography.titleLarge,
            color = BackDeg2,
        )
        Text(
            text = album?.description ?: "No description",
            style = MaterialTheme.typography.bodyMedium,
            color = Hueso,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
    Row(Modifier
        .padding(start = 10.dp, top= 5.dp)
        .clip(RoundedCornerShape(16.dp))
        .border(
            width = 1.2.dp,
            brush = Brush.horizontalGradient(listOf(BackDeg5, BackDeg4)),
            shape = RoundedCornerShape(16.dp)
        )
        .background(Color.Transparent.copy(0.2f))
        .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text= "Artist : ",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = BackDeg2)
        Text(
            text = album?.artist ?: "No artist",
            style = MaterialTheme.typography.bodyMedium,
            color = Hueso,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}
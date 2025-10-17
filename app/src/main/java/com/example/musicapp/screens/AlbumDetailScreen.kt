package com.example.musicapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.components.ALbumDetails
import com.example.musicapp.components.DetailBox
import com.example.musicapp.components.RecentlyCard
import com.example.musicapp.components.Speaker
import com.example.musicapp.components.TrackCard
import com.example.musicapp.models.albums
import com.example.musicapp.ui.theme.BackDeg1
import com.example.musicapp.ui.theme.BackDeg2
import com.example.musicapp.ui.theme.BackDeg3
import com.example.musicapp.ui.theme.BackDeg4
import com.example.musicapp.ui.theme.BackDeg5
import com.example.musicapp.ui.theme.Hueso
import com.example.musicapp.ui.theme.MusicAppTheme

@Composable
fun AlbumDetailScreen(id: String, nav: NavController, padding: PaddingValues){
    val album = albums.firstOrNull{ it.id == id }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(BackDeg1, BackDeg2, BackDeg3, BackDeg4, BackDeg5),
                    start = Offset(0f, 0f),
                    end = Offset(0f, 1500f)
                )
            )
            .padding(top = 28.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        LazyColumn(Modifier.fillMaxSize()) {
            item {
                DetailBox(nav, album)
            }
            item {
                ALbumDetails(album)
            }
            items(count = 10){ i ->
                TrackCard(album, (i+1))
            }
        }
        Speaker() { }
    }
}

@Preview
@Composable
fun ADSPreview(){
    MusicAppTheme {
        AlbumDetailScreen("682243ecf60db4caa642a48e", rememberNavController(), PaddingValues(16.dp))
    }
}
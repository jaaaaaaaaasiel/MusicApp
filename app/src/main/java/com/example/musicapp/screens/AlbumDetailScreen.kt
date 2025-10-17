package com.example.musicapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.composables.PauseCircle
import com.composables.PlayCircle
import com.example.musicapp.components.ActionsDetail
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
            .background(brush = Brush.linearGradient(listOf(BackDeg1, BackDeg2, BackDeg3, BackDeg4, BackDeg5),
            start = Offset(0f, 0f),
            end = Offset(0f, 1500f))
            )
            .padding(top = 28.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Box(modifier = Modifier
                    .padding(top = 11.dp, start = 9.dp, end = 9.dp, bottom = 16.dp)
                    .fillMaxWidth()
                    .height(310.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.00f to BackDeg3,
                            0.40f to BackDeg2,
                            0.95f to BackDeg1,
                            1f to Color.Red.copy(alpha = 0.85f)
                        ))
                    )
                    .padding(top = 19.dp, start = 14.dp, end = 14.dp, bottom = 30.dp)
                ){
                    Column(
                        Modifier.fillMaxSize()
                    ) {
                        ActionsDetail()
                        Spacer(Modifier.weight(1f))
                        Column(
                            modifier = Modifier
                                .height(100.dp)
                                .width(150.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.Transparent.copy(0.2f))
                                .padding(5.dp)
                        ) {
                            Text(
                                text = album?.title ?: "No hay Album Seleccionado",
                                style = MaterialTheme.typography.titleLarge,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(start = 5.dp),
                                color = Hueso
                            )
                            Text(
                                text = album?.artist ?: "No hay Artista Seleccionado",
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

                }
            }
        }
    }
}

@Preview
@Composable
fun ADSPreview(){
    MusicAppTheme {
        AlbumDetailScreen("682243ecf60db4caa642a48e", rememberNavController(), PaddingValues(16.dp))
    }
}
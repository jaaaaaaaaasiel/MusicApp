package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.musicapp.models.Album
import com.example.musicapp.ui.theme.BackDeg1
import com.example.musicapp.ui.theme.BackDeg2
import com.example.musicapp.ui.theme.BackDeg3
import com.example.musicapp.ui.theme.routes.HomeScreenRoute

@Composable
fun DetailBox(nav: NavController, album: Album?) {
    Box(
        modifier = Modifier
            .padding(top = 11.dp, start = 9.dp, end = 9.dp, bottom = 16.dp)
            .fillMaxWidth()
            .height(310.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.00f to BackDeg3,
                        0.40f to BackDeg2,
                        0.95f to BackDeg1,
                        1f to Color.Red.copy(alpha = 0.85f)
                    )
                )
            )
    ) {
        AsyncImage(
            model = album?.image,
            contentDescription = album?.title,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(24.dp))
                .background(Color.Transparent),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 19.dp, start = 14.dp, end = 14.dp, bottom = 30.dp)
        ) {
            ActionsDetail{
                nav.navigate(HomeScreenRoute)
            }
            Spacer(Modifier.weight(1f))
            AlbumReproducer(album)
        }
    }
}
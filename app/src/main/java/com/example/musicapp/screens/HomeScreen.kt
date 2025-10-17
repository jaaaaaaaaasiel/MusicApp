package com.example.musicapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.components.AlbumCard
import com.example.musicapp.components.Header1
import com.example.musicapp.components.RecentlyCard
import com.example.musicapp.components.Speaker
import com.example.musicapp.components.TopBox
import com.example.musicapp.models.albums
import com.example.musicapp.ui.theme.BackDeg1
import com.example.musicapp.ui.theme.BackDeg2
import com.example.musicapp.ui.theme.BackDeg3
import com.example.musicapp.ui.theme.BackDeg4
import com.example.musicapp.ui.theme.BackDeg5
import com.example.musicapp.ui.theme.MusicAppTheme
import com.example.musicapp.ui.theme.routes.AlbumDetailScreenRoute

@Composable
fun HomeScreen(
    nav: NavController,
    padding: PaddingValues,
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.linearGradient(listOf(BackDeg1, BackDeg2, BackDeg3, BackDeg4, BackDeg5),
            start = Offset(0f, 0f),
            end = Offset(0f, 1500f)
        ))
        .padding(top = 28.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
        ) {
            item {
                TopBox()
            }

            item{
                Column {
                    Header1("Albums")
                    LazyRow(modifier = Modifier
                        .padding(vertical = 9.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        items(albums){ album ->
                            AlbumCard(album){
                                nav.navigate(AlbumDetailScreenRoute(album.id))
                            }
                        }
                    }
                }
            }

            item {
                Header1("Recently Played")
            }

            items(albums){ album ->
                RecentlyCard(album){
                    nav.navigate(AlbumDetailScreenRoute(album.id))
                }
            }

        }
        var selectedAlbumId by rememberSaveable { mutableStateOf(albums[1].id) }
        val selectedAlbum = remember(selectedAlbumId) { albums.first{it.id == selectedAlbumId}}
        Speaker(selectedAlbum){
            nav.navigate(AlbumDetailScreenRoute(selectedAlbum.id))

        }
    }

}

@Preview
@Composable
fun HSPreview(){
    MusicAppTheme {
        HomeScreen(nav = rememberNavController(), PaddingValues(16.dp))
    }
}
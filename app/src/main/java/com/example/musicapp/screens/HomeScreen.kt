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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.musicapp.components.AlbumCard
import com.example.musicapp.components.Header1
import com.example.musicapp.components.RecentlyCard
import com.example.musicapp.components.Speaker
import com.example.musicapp.components.TopBox
import com.example.musicapp.ui.theme.BackDeg1
import com.example.musicapp.ui.theme.BackDeg2
import com.example.musicapp.ui.theme.BackDeg3
import com.example.musicapp.ui.theme.BackDeg4
import com.example.musicapp.ui.theme.BackDeg5
import com.example.musicapp.ui.theme.routes.AlbumDetailScreenRoute
import com.example.musicapp.viewmodel.AlbumsViewModel
import com.example.musicapp.viewmodel.SharedViewModel

@Composable
fun HomeScreen(
    nav: NavController,
    padding: PaddingValues,
    sharedViewModel: SharedViewModel
){
    val vm: AlbumsViewModel = viewModel()

    LaunchedEffect(true) {
        vm.loadAblbums()
    }

    if (vm.loading){
        Box(
            Modifier
                .fillMaxSize()
                .background(BackDeg5),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    } else {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(listOf(BackDeg1, BackDeg2, BackDeg3, BackDeg4, BackDeg5),
                start = Offset(0f, 0f),
                end = Offset(0f, 1500f)
            ))
            .padding(top = 55.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
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
                            items(vm.albums){ album ->
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

                items(vm.albums){ album ->
                    RecentlyCard(album){
                        nav.navigate(AlbumDetailScreenRoute(album.id))
                    }
                }

            }
            val selectedAlbumId = sharedViewModel.selectedAlbumId
            val selectedAlbum = remember(selectedAlbumId) {
                vm.albums.firstOrNull { it.id == selectedAlbumId }
            }

            Speaker(selectedAlbum){
                nav.navigate(AlbumDetailScreenRoute(selectedAlbum?.id ?: ""))

            }
        }
    }
}


package com.example.musicapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.musicapp.components.ALbumDetails
import com.example.musicapp.components.DetailBox
import com.example.musicapp.components.Speaker
import com.example.musicapp.components.TrackCard
import com.example.musicapp.ui.theme.BackDeg1
import com.example.musicapp.ui.theme.BackDeg2
import com.example.musicapp.ui.theme.BackDeg3
import com.example.musicapp.ui.theme.BackDeg4
import com.example.musicapp.ui.theme.BackDeg5
import com.example.musicapp.viewmodel.AlbumDetailViewModel
import com.example.musicapp.viewmodel.SharedViewModel

@Composable
fun AlbumDetailScreen(
    id: String,
    nav: NavController,
    padding: PaddingValues,
    sharedViewModel: SharedViewModel
){
    val vm: AlbumDetailViewModel = viewModel()
    LaunchedEffect(true) {
        vm.loadAlbum(id)
    }
    LaunchedEffect(id) {
        sharedViewModel.selectAlbum(id)
    }
    if (vm.loading){
        Box(
            Modifier
                .fillMaxSize()
                .background(BackDeg1),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    } else {
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
                .padding(top = 55.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            LazyColumn(Modifier.fillMaxSize()) {
                item {
                    DetailBox(nav, vm.album)
                }
                item {
                    ALbumDetails(vm.album)
                }
                items(count = 10){ i ->
                    TrackCard(vm.album, (i+1))
                }
            }
            Speaker(vm.album) { }
        }

    }

}


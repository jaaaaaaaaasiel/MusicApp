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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val listSate = rememberLazyListState()
    var centerIndex by remember { mutableStateOf(0) }


    LaunchedEffect(true) {
        vm.loadAblbums()
    }
    LaunchedEffect(listSate.firstVisibleItemIndex, listSate.firstVisibleItemScrollOffset) {
        val visibleItems = listSate.layoutInfo.visibleItemsInfo
        if (visibleItems.isNotEmpty()) {
            val viewportCenter = listSate.layoutInfo.viewportEndOffset /2
            centerIndex = visibleItems.minByOrNull {
                kotlin.math.abs(it.offset + it.size / 2 - viewportCenter)
            }?.index ?: 0
        }
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
                        LazyRow(
                            state = listSate,
                            modifier = Modifier
                            .padding(vertical = 9.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            itemsIndexed(vm.albums){ index, album ->
                                val distance = kotlin.math.abs(index - centerIndex)
                                val scale = 1f - 0.3f * distance.coerceAtMost(1)
                                AlbumCard(album, scale){
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


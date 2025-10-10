package com.example.musicapp.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.ui.theme.MusicAppTheme

@Composable
fun AlbumDetailScreen(id: String, nav: NavController, padding: PaddingValues){

}

@Preview
@Composable
fun ADSPreview(){
    MusicAppTheme {
        AlbumDetailScreen("682243ecf60db4caa642a48e", rememberNavController(), PaddingValues(16.dp))
    }
}
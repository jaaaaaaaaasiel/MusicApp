package com.example.musicapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.ui.theme.MusicAppTheme

@Composable
fun HomeScreen(nav: NavController, padding: PaddingValues){
    Column(modifier = Modifier
        .fillMaxSize()
    ) {

    }
}

@Preview
@Composable
fun HSPreview(){
    MusicAppTheme {
        HomeScreen(nav = rememberNavController(), PaddingValues(16.dp))
    }
}
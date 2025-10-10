package com.example.musicapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.ui.theme.BackDeg1
import com.example.musicapp.ui.theme.BackDeg2
import com.example.musicapp.ui.theme.BackDeg3
import com.example.musicapp.ui.theme.BackDeg4
import com.example.musicapp.ui.theme.BackDeg5
import com.example.musicapp.ui.theme.MusicAppTheme

@Composable
fun HomeScreen(nav: NavController, padding: PaddingValues){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.linearGradient(listOf(BackDeg1, BackDeg2, BackDeg3, BackDeg4, BackDeg5),
            start = Offset(0f, 0f),
            end = Offset(0f, 1500f)
        ))
        .padding(top = 28.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
        ) {
            item {
                Column(modifier = Modifier
                    .padding(horizontal = 9.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(21.dp))
                    .shadow(elevation = 4.dp)
                    .background(Brush.linearGradient(listOf(BackDeg2, BackDeg1, Color.Red),
                        start = Offset(0f, 0f),
                        end = Offset(0f, 400f)))
                ) {

                }
            }

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
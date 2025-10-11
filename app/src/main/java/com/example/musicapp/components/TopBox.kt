package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.musicapp.ui.theme.BackDeg1
import com.example.musicapp.ui.theme.BackDeg2

@Composable
fun TopBox(){
    Column(modifier = Modifier
        .padding(top = 11.dp, start = 9.dp, end = 9.dp, bottom = 16.dp)
        .fillMaxWidth()
        .height(150.dp)
        .clip(RoundedCornerShape(21.dp))
        .background(Brush.linearGradient(listOf(BackDeg2, BackDeg1, Color.Red),
            start = Offset(0f, 0f),
            end = Offset(0f, 500f)))
        .padding(all = 21.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
        ) {
            Icon(Icons.Default.Menu, null)
            Spacer(Modifier.weight(1f))
            Icon(Icons.Default.Search,null)
        }
        Text(
            text= "Good Morning!",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Medium
        )
        Text(
            text= "Carlos Morrison",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium
        )
    }
}
package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.musicapp.ui.theme.Hueso

@Composable
fun ActionsDetail(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            Icons.AutoMirrored.Filled.ArrowBack,
            "Back",
            tint = Hueso,
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .border(width = 0.5.dp, Hueso, shape = CircleShape)
                .background(Color.Transparent.copy(alpha = 0.25f))
                .padding(5.dp)
        )
        Spacer(Modifier.weight(1f))
        Icon(
            Icons.Default.FavoriteBorder,
            "Favorite",
            tint= Hueso,
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .border(width = 0.5.dp, Hueso, shape = CircleShape)
                .background(Color.Transparent.copy(alpha = 0.25f))
                .padding(5.dp)
        )
    }
}
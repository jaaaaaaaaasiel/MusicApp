package com.example.musicapp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Header1(header: String){
    Row(modifier = Modifier
        .padding(horizontal = 9.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = header,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "See more",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White
        )
    }
}
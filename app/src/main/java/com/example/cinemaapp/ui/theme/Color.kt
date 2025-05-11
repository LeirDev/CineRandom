package com.example.cinemaapp.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

val BackgroundColor = Color(0xFF100F0F)


@Composable
fun PreviewColors() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Box(modifier = Modifier.size(50.dp).background(BackgroundColor)) {
            Text(
                text = "Cor de Fundo",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

package com.example.cinemaapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.cinemaapp.ui.theme.BackgroundColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.cinemaapp.R

@Composable
fun GenreSelectionScreen(onGenreSelected: (String) -> Unit) {
    val genres = listOf("Ação", "Terror", "Comédia", "Romance")


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Image(
            painter = painterResource(R.drawable.cinema_chair),
            contentDescription = "cadeiras de cinema para design",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(577.dp)
                .height(400.dp)
                .align (Alignment.BottomEnd)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Escolha um gênero de filme:",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .padding(top = 70.dp)
            )
            Spacer(modifier = Modifier.padding(top = 70.dp))
            genres.forEach { genre ->
                Button(
                    onClick = { onGenreSelected(genre) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEA1D21)),
                    modifier = Modifier
                        .width(160.dp)
                        .height(70.dp)
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = genre, color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }


    }


@Preview(showBackground = true)
@Composable
fun PreviewGenreSelectionScreen() {
    GenreSelectionScreen(onGenreSelected = {})
}


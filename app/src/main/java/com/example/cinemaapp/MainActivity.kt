package com.example.cinemaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinemaapp.ui.screens.GenreSelectionScreen
import com.example.cinemaapp.ui.screens.RandomMovieScreen
import com.example.cinemaapp.ui.theme.CinemaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaAppTheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "genre_selection") {
        composable("genre_selection") {
            GenreSelectionScreen(onGenreSelected = { genre ->
                navController.navigate("random_movie/$genre")
            })
        }
        composable("random_movie/{genre}") { backStackEntry ->
            val genre = backStackEntry.arguments?.getString("genre") ?: ""
            RandomMovieScreen(genre = genre)
        }
    }
}

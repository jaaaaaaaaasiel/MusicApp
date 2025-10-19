package com.example.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.musicapp.screens.AlbumDetailScreen
import com.example.musicapp.screens.HomeScreen
import com.example.musicapp.ui.theme.MusicAppTheme
import com.example.musicapp.ui.theme.routes.AlbumDetailScreenRoute
import com.example.musicapp.ui.theme.routes.HomeScreenRoute
import com.example.musicapp.viewmodel.SharedViewModel

class MainActivity : ComponentActivity() {
    val sharedViewModel = SharedViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicAppTheme {
                val nav = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    NavHost(
                        navController = nav,
                        startDestination = HomeScreenRoute
                    ) {
                        composable<HomeScreenRoute> {
                            HomeScreen(
                                nav = nav,
                                padding = PaddingValues(
                                    top = 30.dp,
                                    start = 16.dp,
                                    end = 16.dp,
                                    bottom = 16.dp
                                ),
                                sharedViewModel = sharedViewModel
                            )
                        }
                        composable<AlbumDetailScreenRoute> { backStack ->
                            val args = backStack.toRoute<AlbumDetailScreenRoute>()
                            AlbumDetailScreen(
                                id = args.id,
                                nav = nav,
                                padding = PaddingValues(
                                    top = 30.dp,
                                    start = 16.dp,
                                    end = 16.dp,
                                    bottom = 16.dp
                                ),
                                sharedViewModel = sharedViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}


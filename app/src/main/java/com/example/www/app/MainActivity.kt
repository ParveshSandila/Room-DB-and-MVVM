package com.example.www.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.www.app.presentation.ui.screens.MovieDetailsScreen
import com.example.www.app.presentation.ui.screens.MovieListScreen
import com.example.www.app.presentation.ui.theme.DuckTaleTaskTheme
import com.example.www.app.presentation.utils.Screens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            DuckTaleTaskTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screens.MovieListScreen.path
                ){
                    composable(
                        route = Screens.MovieListScreen.path
                    ){
                        MovieListScreen(
                            onItemClick = { id ->
                                navController.navigate(
                                    Screens.MovieDetailsScreen.createPath(id)
                                )
                            }
                        )
                    }

                    composable(
                        route = Screens.MovieDetailsScreen.path
                    ){
                        MovieDetailsScreen(

                        )
                    }
                }
            }
        }
    }
}

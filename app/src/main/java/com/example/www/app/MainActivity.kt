package com.example.www.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgs
import androidx.navigation.navArgument
import com.example.www.app.presentation.ui.screens.MovieDetailsScreen
import com.example.www.app.presentation.ui.screens.MovieListScreen
import com.example.www.app.presentation.ui.theme.DuckTaleTaskTheme
import com.example.www.app.presentation.utils.Screens
import com.example.www.app.presentation.viewmodels.MovieListScreenVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            DuckTaleTaskTheme {
                NavHost(
                    modifier = Modifier.fillMaxSize(),
                    navController = navController,
                    startDestination = Screens.MovieListScreen.path
                ){
                    composable(
                        route = Screens.MovieListScreen.path
                    ){
                        MovieListScreen(
                            modifier = Modifier.fillMaxSize(),
                            onItemClick = { id ->
                                navController.navigate(
                                    Screens.MovieDetailsScreen.createPath(id)
                                )
                            }
                        )
                    }

                    composable(
                        route = Screens.MovieDetailsScreen.path,
                        arguments = listOf(
                            navArgument("id"){
                                type = NavType.IntType
                            }
                        )
                    ){
                        MovieDetailsScreen(
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                }
            }
        }
    }
}

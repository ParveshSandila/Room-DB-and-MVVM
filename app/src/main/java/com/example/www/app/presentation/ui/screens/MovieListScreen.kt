package com.example.www.app.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.www.app.presentation.viewmodels.MovieListScreenVM

@Composable
fun MovieListScreen(
    modifier: Modifier = Modifier,
    onItemClick: (id:Int) -> Unit,
    viewModel : MovieListScreenVM = hiltViewModel()
) {

}
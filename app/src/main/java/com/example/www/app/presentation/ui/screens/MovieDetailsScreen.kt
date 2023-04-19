package com.example.www.app.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.www.app.R
import com.example.www.app.presentation.ui.composables.CustomImageView
import com.example.www.app.presentation.ui.composables.LabelText
import com.example.www.app.presentation.viewmodels.MovieDetailsScreenVM

@Composable
fun MovieDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel : MovieDetailsScreenVM = hiltViewModel()
) {

    val movieDetails by viewModel.details.collectAsState()

    movieDetails?.let { movie ->
        Column(
            modifier = modifier.verticalScroll(
                rememberScrollState()
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ){
                CustomImageView(
                    modifier = Modifier.fillMaxSize(),
                    imageUrl = movie.posterUrl,
                    contentDescription = "Movie Poster"
                )

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                Color(0x14B6B6B6),
                                Color(0x7AA5A5A5)
                            )
                        )
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier.padding(
                    horizontal = 15.dp
                )
            ) {
                LabelText(
                    label = stringResource(id = R.string.title),
                    value = movie.title,
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(15.dp))

                Divider()

                Spacer(modifier = Modifier.height(15.dp))

                LabelText(
                    label = stringResource(id = R.string.year),
                    value = movie.year
                )

                Spacer(modifier = Modifier.height(15.dp))

                LabelText(
                    label = stringResource(id = R.string.runtime),
                    value = movie.runtime.plus(" mins")
                )

                Spacer(modifier = Modifier.height(15.dp))

                LabelText(
                    label = stringResource(id = R.string.actors),
                    value = movie.actors
                )

                Spacer(modifier = Modifier.height(15.dp))

                LabelText(
                    label = stringResource(id = R.string.genres),
                    value = movie.genres
                )

                Spacer(modifier = Modifier.height(15.dp))

                LabelText(
                    label = stringResource(id = R.string.plot),
                    value = movie.plot
                )
            }
        }
    }
}
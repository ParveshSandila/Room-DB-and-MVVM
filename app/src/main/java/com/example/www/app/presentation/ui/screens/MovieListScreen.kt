package com.example.www.app.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.www.app.R
import com.example.www.app.domain.models.Movie
import com.example.www.app.presentation.ui.composables.CustomImageView
import com.example.www.app.presentation.ui.composables.LabelText
import com.example.www.app.presentation.viewmodels.MovieListScreenVM

@Composable
fun MovieListScreen(
    modifier: Modifier = Modifier,
    onItemClick: (id:Int) -> Unit,
    viewModel : MovieListScreenVM = hiltViewModel()
) {

    val list by viewModel.moviesList.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    Column(
        modifier = modifier
    ) {
        SearchBar(
            value = searchQuery,
            onValueChanged = {
                viewModel.search(it)
            }
        )

        if(list.isNotEmpty()){
            LazyColumn(
                modifier = Modifier.padding(
                    vertical = 10.dp
                )
            ){
                items(list){ movie ->
                    ListItem(movie){ id ->
                        onItemClick(id)
                    }
                }
            }
        }else{
            EmptyList(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchBar(
    value: String,
    onValueChanged : (String) -> Unit
){
    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp
                )
            )
            .fillMaxWidth()
            .padding(
                horizontal = 15.dp,
                vertical = 15.dp
            ),
    ){

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Search Here")
            },
            value = value ,
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Medium
            ),
            trailingIcon = {
                if(value.isNotEmpty()){
                    Icon(
                        modifier = Modifier.clickable {
                            onValueChanged("")
                        },
                        painter = painterResource(id = R.drawable.ic_clear),
                        contentDescription = "Clear Text"
                    )
                }
            },
            singleLine = true,
            onValueChange = {
                onValueChanged(it)
            },
            colors = textFieldColors(
                cursorColor = MaterialTheme.colors.onPrimary,
                focusedIndicatorColor = MaterialTheme.colors.onPrimary,
                unfocusedIndicatorColor = MaterialTheme.colors.onPrimary,
                backgroundColor = MaterialTheme.colors.primary,
                focusedLabelColor = MaterialTheme.colors.onPrimary,
                placeholderColor = MaterialTheme.colors.onPrimary,
                trailingIconColor = MaterialTheme.colors.onPrimary,
                focusedTrailingIconColor = MaterialTheme.colors.onPrimary,
            )

        )
    }
}

@Composable
private fun EmptyList(
    modifier: Modifier
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .border(
                    color = Color(0xFFD9D9D9),
                    shape = RoundedCornerShape(5.dp),
                    width = 1.dp
                )
                .padding(15.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(
                    80.dp
                ),
                painter = painterResource(id = R.drawable.ic_list),
                contentDescription = "Empty List",
                tint = Color(0xFFD9D9D9)
            )

            Text(
                text = stringResource(id = R.string.no_content),
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color(0xFFD9D9D9)
                )
            )
        }
    }
}

@Composable
private fun ListItem(
    movie: Movie,
    onItemClick: (id: Int) -> Unit
){
    Column(
        modifier = Modifier
            .clickable {
                onItemClick(movie.id)
            }
            .padding(
                start = 5.dp,
                end = 5.dp,
                bottom = 5.dp
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomImageView(
                modifier = Modifier
                    .size(108.dp)
                    .clip(RoundedCornerShape(5.dp)),
                imageUrl = movie.posterUrl,
                contentDescription = "Movie Poster"
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                horizontalAlignment = Alignment.Start
            ) {

                LabelText(
                    label = stringResource(id = R.string.title),
                    value = movie.title
                )

                Spacer(modifier = Modifier.height(10.dp))

                LabelText(
                    label = stringResource(id = R.string.year),
                    value = movie.year
                )
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Divider(color = Color(0xFFE9E9E9))
    }
}
package com.example.www.app.presentation.utils

import androidx.annotation.StringRes
import com.example.www.app.R

sealed class Screens(
    val path:String,
    @StringRes val titleResId : Int
){
    object MovieListScreen : Screens(
        path = "movie_list_screen",
        titleResId = R.string.movie_list
    )

    object MovieDetailsScreen : Screens(
        path = "movie_details/{id}",
        titleResId = R.string.movie_list
    ){
        fun createPath(id:Int) = "movie_details/$id"
    }
}
package com.example.www.app.domain.repository

import com.example.www.app.domain.models.Movie
import com.example.www.app.domain.models.MovieDetails

interface MoviesRepo {
    fun getMoviesList(query:String) : List<Movie>
    fun getMovieDetails(id:Int) : MovieDetails
}
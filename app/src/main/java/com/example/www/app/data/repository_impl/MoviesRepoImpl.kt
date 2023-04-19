package com.example.www.app.data.repository_impl

import com.example.www.app.data.local_db.MoviesDB
import com.example.www.app.data.local_db.entities.MovieEntity
import com.example.www.app.domain.models.Movie
import com.example.www.app.domain.models.MovieDetails
import com.example.www.app.domain.repository.MoviesRepo

class MoviesRepoImpl(
    private val moviesDB: MoviesDB
) : MoviesRepo {

    override fun getMoviesList(query: String): List<Movie> {
       return moviesDB.moviesDao.getMoviesList(query).map { it.toMovie() }
    }

    override fun getMovieDetails(id: Int): MovieDetails {
        return moviesDB.moviesDao.getMovieDetails(id).toMovieDetails()
    }
}
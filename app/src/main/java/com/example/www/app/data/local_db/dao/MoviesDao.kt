package com.example.www.app.data.local_db.dao

import androidx.room.Query
import com.example.www.app.data.local_db.entities.MovieEntity
import com.example.www.app.domain.models.Movie

interface MoviesDao {

    @Query("select * from where title LIKE '%' {query} '%' ORDER BY title ASC")
    fun getMoviesList(query:String) : List<MovieEntity>
}
package com.example.www.app.data.local_db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.www.app.data.local_db.entities.MovieEntity

@Dao
interface MoviesDao {

    @Query("SELECT * FROM MovieEntity WHERE title LIKE '%' || :query || '%' ORDER BY title ASC")
    fun getMoviesList(query:String) : List<MovieEntity>

    @Query("SELECT * FROM MovieEntity WHERE id == :id")
    fun getMovieDetails(id:Int) : MovieEntity
}
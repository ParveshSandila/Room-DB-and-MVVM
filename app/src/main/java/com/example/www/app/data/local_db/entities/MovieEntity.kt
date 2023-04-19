package com.example.www.app.data.local_db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.www.app.domain.models.Movie
import com.example.www.app.domain.models.MovieDetails

@Entity
data class MovieEntity(
    @PrimaryKey
    val id:Int? = null,

    @ColumnInfo(name = "title")
    val title:String,

    @ColumnInfo(name = "posterUrl")
    val posterUrl:String,

    @ColumnInfo(name = "year")
    val year:String,

    @ColumnInfo(name = "runtime")
    val runtime : String,

    @ColumnInfo(name= "genres")
    val genres:String,

    @ColumnInfo(name = "director")
    val director:String,

    @ColumnInfo(name= "actors")
    val actors : String,

    @ColumnInfo(name = "plot")
    val plot:String
){
    fun toMovie() = Movie(
        id= id ?: 0,
        title = title,
        posterUrl = posterUrl,
        year = year
    )

    fun toMovieDetails() = MovieDetails(
        id= id ?: 0,
        title = title,
        posterUrl = posterUrl,
        plot = plot,
        actors = actors,
        genres = genres,
        year = year,
        runtime = runtime
    )
}

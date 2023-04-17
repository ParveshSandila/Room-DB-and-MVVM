package com.example.www.app.data.local_db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.www.app.domain.models.Movie

@Entity
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    @ColumnInfo(name = "title")
    val title:String,

    @ColumnInfo(name = "posterUrl")
    val posterUrl:String,

    @ColumnInfo(name = "releaseDate")
    val releaseDate:String,

    @ColumnInfo(name = "rating")
    val rating:Int,

    @ColumnInfo(name= "genre")
    val genre:String,

    @ColumnInfo(name = "about")
    val about:Int
){
    fun toMovie() = Movie(
        id= id,
        title = title,
        posterUrl = posterUrl,
        releaseDate = releaseDate
    )
}
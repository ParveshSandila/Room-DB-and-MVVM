package com.example.www.app.data.local_db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.www.app.data.local_db.dao.MoviesDao
import com.example.www.app.data.local_db.entities.MovieEntity


@TypeConverters(TypeConverter::class)
@Database(entities = [MovieEntity::class], version = 2, exportSchema = false)
abstract class MoviesDB : RoomDatabase() {
    abstract val moviesDao : MoviesDao
}
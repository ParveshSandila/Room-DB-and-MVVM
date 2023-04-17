package com.example.www.app.data.local_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.www.app.data.local_db.dao.MoviesDao


@Database(entities = [], version = 1)
abstract class MoviesDB : RoomDatabase() {
    abstract val moviesDao : MoviesDao
}
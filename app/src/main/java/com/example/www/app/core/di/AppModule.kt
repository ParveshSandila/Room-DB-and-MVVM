package com.example.www.app.core.di

import android.content.Context
import androidx.room.Room
import com.example.www.app.data.local_db.MoviesDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMoviesDB(@ApplicationContext context: Context): MoviesDB {
        return Room.databaseBuilder(context, MoviesDB::class.java, "app.db")
            .createFromAsset("database/sqlite.db")
            .build()
    }

}

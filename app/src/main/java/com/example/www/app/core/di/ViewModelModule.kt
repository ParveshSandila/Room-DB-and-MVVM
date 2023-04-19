package com.example.www.app.core.di

import com.example.www.app.data.local_db.MoviesDB
import com.example.www.app.data.repository_impl.MoviesRepoImpl
import com.example.www.app.domain.repository.MoviesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {
    @Provides
    @ViewModelScoped
    fun provideMoviesRepo(moviesDB: MoviesDB) : MoviesRepo = MoviesRepoImpl(moviesDB)
}
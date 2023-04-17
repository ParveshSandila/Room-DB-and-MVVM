package com.example.www.app.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.www.app.domain.models.Movie
import com.example.www.app.domain.repository.MoviesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class MovieListScreenVM @Inject constructor(
    private val moviesRepo: MoviesRepo,
) : ViewModel() {

    private var searchJob : Job? = null

    private val _moviesList = MutableStateFlow<List<Movie>>(emptyList())
    val moviesList = _moviesList.asStateFlow()

    fun search(query:String){
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(300)

            _moviesList.value = if(query.isNotEmpty()){
                moviesRepo.getMoviesList(query)
            }else{
                emptyList()
            }
        }
    }
}
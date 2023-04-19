package com.example.www.app.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.www.app.domain.models.Movie
import com.example.www.app.domain.repository.MoviesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListScreenVM @Inject constructor(
    private val moviesRepo: MoviesRepo,
) : ViewModel() {

    private var searchJob : Job? = null

    private val _moviesList = MutableStateFlow<List<Movie>>(emptyList())
    val moviesList = _moviesList.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    fun search(query:String){
        _searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch(Dispatchers.IO) {
            delay(500)
            _moviesList.emit(
                if(query.trim().length > 2){
                    moviesRepo.getMoviesList(query.trim())
                }else{
                    emptyList()
                }
            )
        }
    }
}
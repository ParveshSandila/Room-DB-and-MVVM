package com.example.www.app.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.www.app.domain.models.MovieDetails
import com.example.www.app.domain.repository.MoviesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsScreenVM @Inject constructor(
    private val moviesRepo: MoviesRepo,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _details = MutableStateFlow<MovieDetails?>(null)
    val details = _details.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            savedStateHandle.get<Int>("id")?.let {
                _details.value = moviesRepo.getMovieDetails(it)
            }
        }
    }
}
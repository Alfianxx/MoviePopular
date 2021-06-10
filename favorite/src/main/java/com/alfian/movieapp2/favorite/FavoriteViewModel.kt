package com.alfian.movieapp2.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.alfian.movieapp.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}


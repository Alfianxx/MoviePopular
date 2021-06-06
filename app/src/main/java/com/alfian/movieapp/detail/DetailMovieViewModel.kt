package com.alfian.movieapp.detail

import androidx.lifecycle.ViewModel
import com.alfian.movieapp.core.domain.model.Movie
import com.alfian.movieapp.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus:Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}


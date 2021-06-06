package com.alfian.movieapp.core.domain.repository

import com.alfian.movieapp.core.data.Resource
import com.alfian.movieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)

}

package com.alfian.movieapp.core.utils

import com.alfian.movieapp.core.data.source.remote.response.MovieResponse
import com.alfian.movieapp.core.data.source.local.entity.MovieEntity
import com.alfian.movieapp.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val tourismList = ArrayList<MovieEntity>()
        input.map {
            val tourism = MovieEntity(
                movieId = it.id,
                overview = it.overview,
                title = it.title,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                popularity = it.popularity,
                posterPath = it.posterPath,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                overview = it.overview,
                title = it.title,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                popularity = it.popularity,
                posterPath = it.posterPath,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        overview = input.overview,
        title = input.title,
        releaseDate = input.releaseDate,
        voteAverage = input.voteAverage,
        popularity = input.popularity,
        posterPath = input.posterPath,
        isFavorite = input.isFavorite
    )
}
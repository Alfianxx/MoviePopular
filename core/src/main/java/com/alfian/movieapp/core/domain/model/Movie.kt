package com.alfian.movieapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val movieId: Int,
    val overview: String,
    val title: String,
    val posterPath: String,
    val releaseDate: String,
    val popularity: Double,
    val voteAverage: Double,
    val isFavorite: Boolean
) : Parcelable
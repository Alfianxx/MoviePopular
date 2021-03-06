package com.alfian.movieapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "rating")
    var voteAverage: Double,

    @ColumnInfo(name = "popularity")
    var popularity: Double,

    @ColumnInfo(name = "poster_path")
    var posterPath: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)

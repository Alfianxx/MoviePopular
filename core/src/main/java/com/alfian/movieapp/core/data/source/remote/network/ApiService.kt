package com.alfian.movieapp.core.data.source.remote.network

import com.alfian.movieapp.core.Constants.API_KEY
import com.alfian.movieapp.core.data.source.remote.response.ListMoviesResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/popular?api_key=$API_KEY")
    suspend fun getList(): ListMoviesResponse

}

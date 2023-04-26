package com.example.rkmovies.api

import com.example.rkmovies.helper.constants
import com.example.rkmovies.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>
}
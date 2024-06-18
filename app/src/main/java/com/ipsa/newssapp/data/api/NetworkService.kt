package com.ipsa.newssapp.data.api

import com.ipsa.newssapp.data.model.TopHeadlineResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("top-headlines")
    suspend fun getTopHeadLine(
        @Query("country") country: String,
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 20
    ): TopHeadlineResponse
}
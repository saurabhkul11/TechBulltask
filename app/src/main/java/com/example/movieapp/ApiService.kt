package com.example.movieapp

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

@GET("/")
suspend fun getMovieDetails
            (@Query("t")movie_title: String,
             @Query("apikey")api_key: String):Response<MovieData>




companion object{
    var retrofitService: ApiService? = null
    fun getInstance(): ApiService {

        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofitService = retrofit.create(ApiService::class.java)
        }
        return retrofitService!!
    }
}
    }

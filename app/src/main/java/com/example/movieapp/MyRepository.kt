package com.example.movieapp

class MyRepository(private var apiService: ApiService) {

  suspend  fun getData(title:String,key:String)=apiService.getMovieDetails(title,key)

}
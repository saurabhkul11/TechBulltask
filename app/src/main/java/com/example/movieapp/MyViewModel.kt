package com.example.movieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch

class MyViewModel(private var repository: MyRepository):ViewModel() {


    private var mdata: MutableLiveData<MovieData>
            = MutableLiveData()

    var ldata: LiveData<MovieData> =mdata

    fun getMovie(title:String,key:String){
        viewModelScope.launch {
            val response=repository.getData(title, key)
            mdata.postValue(response.body())
        }
    }

}
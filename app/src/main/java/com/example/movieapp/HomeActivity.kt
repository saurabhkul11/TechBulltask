package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var viewModel: MyViewModel
    lateinit var adp: HomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService=ApiService.getInstance()
        viewModel=ViewModelProvider(this,MyViewModelFactory(MyRepository(apiService))).get(MyViewModel::class.java)

        filterData()
        viewModel.ldata.observe(this, Observer {
            adp= HomeAdapter(this, listOf(it))
            binding.recv.apply {
                layoutManager=LinearLayoutManager(this@HomeActivity)
                adapter=adp
            }
        })
      //  viewModel.getMovie(binding.search.toString(),Constants.KEY)
    }



    fun filterData(){
        binding.search.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.getMovie(newText.toString(),Constants.KEY)
                return true
            }

        })
    }
}

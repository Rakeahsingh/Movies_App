package com.example.rkmovies

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rkmovies.adapter.TvShowAdapter
import com.example.rkmovies.databinding.ActivityHomeBinding
import com.example.rkmovies.viewmodal.TvShowViewModal
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: TvShowViewModal by viewModels()
    private lateinit var tvShowAdapter: TvShowAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvShowAdapter = TvShowAdapter{
            val intent = Intent(this,Details::class.java)
            intent.putExtra("TvShowItem",it)
            startActivity(intent)
        }

        binding.rcyclerview.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(this@Home,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)

        }

        binding.rv.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(this@Home,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)

        }

       viewModel.responseTvShow.observe(this,{ listTvShow ->
         tvShowAdapter.tvShows = listTvShow
       })

    }
    override fun onDestroy() {
        super.onDestroy()
        binding != null
    }
}
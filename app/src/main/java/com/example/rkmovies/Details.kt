package com.example.rkmovies

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.rkmovies.databinding.ActivityDetailsBinding
import com.example.rkmovies.models.TvShowItem


class Details : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvShowItem =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                intent.getSerializableExtra("TvShowItem", TvShowItem::class.java)

            else
                intent.getSerializableExtra("TvShowItem") as TvShowItem

        if (tvShowItem != null){
            binding.fmimgv.load(tvShowItem.image.original)
            binding.txtv.text = tvShowItem.name
        }

    }
}
package com.example.rkmovies.models

import java.io.Serializable


data class TvShowItem(

    val id: Int,
    val image: Image,
    val name: String,

) : Serializable
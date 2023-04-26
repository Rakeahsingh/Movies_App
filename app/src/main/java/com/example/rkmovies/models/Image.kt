package com.example.rkmovies.models

import java.io.Serializable

data class Image(
    val medium: String,
    val original: String
) : Serializable
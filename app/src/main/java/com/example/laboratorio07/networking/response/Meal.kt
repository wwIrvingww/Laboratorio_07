package com.example.laboratorio07.networking.response


import com.squareup.moshi.Json

data class Meal(
    @Json(name = "strCategory")
    val strCategory: String
)
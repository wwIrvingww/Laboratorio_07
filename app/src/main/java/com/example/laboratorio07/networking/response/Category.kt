package com.example.laboratorio07.networking.response



import com.squareup.moshi.Json

data class Category(
    @Json(name = "meals")
    val meals: List<Meal>
)
package com.example.laboratorio07.networking.response



import com.squareup.moshi.Json

data class Category(
    //@Json(name = "idCategory")
    val idCategory: String,

    //@Json(name = "strCategory")
    val strCategory: String,

    //@Json(name = "strCategoryThumb")
    val strCategoryThumb: String,

    val strCategoryDescription: String



)

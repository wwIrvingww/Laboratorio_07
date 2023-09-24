package com.example.laboratorio07.ui.categories.viewmodel

import com.example.laboratorio07.networking.response.Category

data class MainState(
    var isloading: Boolean = false,
    val categories: List<Category> = emptyList()

)

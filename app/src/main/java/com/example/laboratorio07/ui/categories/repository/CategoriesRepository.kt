package com.example.laboratorio07.ui.categories.repository

import com.example.laboratorio07.networking.MealsApi
import com.example.laboratorio07.networking.MealsWebService
import com.example.laboratorio07.networking.response.Category
import com.example.laboratorio07.networking.response.MealsResponse

class CategoriesRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMealsCategories(): List<Category> {
        return webService.getMealsCategories().categories
    }
}
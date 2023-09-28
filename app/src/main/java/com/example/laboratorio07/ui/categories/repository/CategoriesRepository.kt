package com.example.laboratorio07.ui.categories.repository

import com.example.laboratorio07.networking.mealsApi
import com.example.laboratorio07.networking.response.Category
import com.example.laboratorio07.networking.response.MealsResponse

class CategoriesRepository (
    private val api: mealsApi

){
    /**
    suspend fun getCategories(): Result<List<Category>>{
        return try {
            val categories = api.getCategories().categories
            Result.success(categories)
        } catch (e: Exception){
            Result.failure(e)
        }
    }*/

    suspend fun getCategories(): MealsResponse {
        return api.getCategories()
    }

}
package com.example.laboratorio07.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.laboratorio07.networking.response.MealCategoryResponse
import com.example.laboratorio07.networking.response.MealsResponse


class MealsWebService {

    private lateinit var api: MealsApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getMealsCategories(): MealsResponse {
        return api.getCategories()
    }

    suspend fun filterMealsByCategory(category: String): MealCategoryResponse {
        return api.filterByCategory(category)
    }

    suspend fun getLookUp(): MealsResponse {
        //se manda a llamar al lookup
        return api.getLookUp()
    }
}
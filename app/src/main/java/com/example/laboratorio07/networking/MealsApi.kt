package com.example.laboratorio07.networking

import com.example.laboratorio07.networking.response.MealCategoryResponse
import com.example.laboratorio07.networking.response.MealsResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    companion object {
        val instance = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(
            OkHttpClient.Builder().build()).build().create(MealsApi::class.java)

    }

    @GET("categories.php")
    suspend fun getCategories(): MealsResponse

    @GET("filter.php")
    suspend fun filterByCategory(
        @Query("c") category: String
    ): MealCategoryResponse

    @GET("lookup.php?i=52944")
    suspend fun getLookUp(): MealsResponse

}


package com.example.laboratorio07.networking

import com.example.laboratorio07.networking.response.Meal
import com.example.laboratorio07.networking.response.mealsResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import java.util.Locale.Category

interface mealsApi {
    companion object {
        val instance = Retrofit.Builder().baseUrl("https://www.themealdb.com").addConverterFactory(MoshiConverterFactory.create()).client(
            OkHttpClient.Builder().build()).build().create(mealsApi::class.java)

    }

    @GET("https://www.themealdb.com/api/json/v1/1/categories.php")
    suspend fun getCategories(): mealsResponse
}
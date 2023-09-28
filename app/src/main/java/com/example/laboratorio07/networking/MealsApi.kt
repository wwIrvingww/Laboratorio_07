package com.example.laboratorio07.networking

import com.example.laboratorio07.networking.response.MealsResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface mealsApi {
    companion object {
        val instance = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(
            OkHttpClient.Builder().build()).build().create(mealsApi::class.java)

    }

    @GET("categories.php")
    suspend fun getCategories(): MealsResponse
}
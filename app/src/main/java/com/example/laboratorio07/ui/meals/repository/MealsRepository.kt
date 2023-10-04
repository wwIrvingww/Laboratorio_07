package com.example.laboratorio07.ui.meals.repository
import com.example.laboratorio07.networking.MealsWebService
import com.example.laboratorio07.networking.response.Meal


class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun filterByCategory(category: String): List<Meal> {
        return webService.filterMealsByCategory(category).meals
    }
}


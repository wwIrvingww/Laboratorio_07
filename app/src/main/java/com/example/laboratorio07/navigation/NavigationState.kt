package com.example.laboratorio07.navigation

sealed class NavigationState(val route: String) {

    object MealsCategories: NavigationState("categories")
    object MealsRecepiesList: NavigationState("categories/{category}")  {
        fun createRoute(category: String) = "categories/$category"
    }

}
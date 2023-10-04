package com.example.laboratorio07.navigation

sealed class NavigationState(val route: String) {

    object MealsCategories: NavigationState("categories")
    object MealsRecepiesList: NavigationState("categories/{category}")  {
        fun createRoute(category: String) = "categories/$category"
    }
    object Home: NavigationState("home")
    object Events: NavigationState("event")
    object Detail: NavigationState("detail")
    object Profile: NavigationState("profile")
    object Settings: NavigationState("settings")
}
package com.example.laboratorio07.navigation

import android.provider.ContactsContract
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.laboratorio07.ui.categories.view.MealsCategoriesScreen
import com.example.laboratorio07.ui.meals.view.MealsFilterScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationState.MealsCategories.route,
        modifier = modifier) {
        composable(route = NavigationState.MealsCategories.route) {
            MealsCategoriesScreen(navController = navController)
        }
        composable(NavigationState.MealsRecepiesList.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val categoryName = arguments.getString("category") ?: ""
            Log.d("ARGUMENTNAV", categoryName)
            MealsFilterScreen(navController = navController, category = categoryName)
        }

    }
}
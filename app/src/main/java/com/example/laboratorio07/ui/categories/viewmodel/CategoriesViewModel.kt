package com.example.laboratorio07.ui.categories.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio07.networking.MealsApi
import com.example.laboratorio07.ui.categories.repository.CategoriesRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laboratorio07.networking.response.Category
import com.example.laboratorio07.networking.response.MealsResponse
import kotlinx.coroutines.Dispatchers

class CategoriesViewModel (private val repository: CategoriesRepository = CategoriesRepository()): ViewModel() {

    val mealsState: MutableState<List<Category>> =  mutableStateOf(emptyList<Category>())

    init {
        Log.d("TAG_COROUTINES", "about to launch a coroutine")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG_COROUTINES", "launching a coroutine")
            val meals = getMealsCategories()
            Log.d("TAG_COROUTINES", "we have received sync data")
            mealsState.value = meals
        }
        Log.d("TAG_COROUTINES", "other work")
    }

    private suspend fun getMealsCategories(): List<Category> {
        return repository.getMealsCategories()
    }
}
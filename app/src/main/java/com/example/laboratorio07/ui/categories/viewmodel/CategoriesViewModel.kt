package com.example.laboratorio07.ui.categories.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio07.networking.mealsApi
import com.example.laboratorio07.ui.categories.repository.CategoriesRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laboratorio07.networking.response.Category
import com.example.laboratorio07.networking.response.MealsResponse

class CategoriesViewModel(
    private val repository: CategoriesRepository = CategoriesRepository(mealsApi.instance)
) : ViewModel() {
    /**var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(isloading = true)
            repository.getCategories().onSuccess {
                state = state.copy(

                    categories = it
                )

            }.onFailure {
                println()
            }
            state = state.copy(isloading = false)
        }

    }*/

    private val _listCategories = MutableLiveData<MealsResponse>()

    val listCategories: LiveData<MealsResponse> = _listCategories

    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val categories = repository.getCategories()
                _listCategories.value = categories

            } catch (e: Exception){
                Log.e("FetchError", e.message.toString())
            }
        }

    }

}
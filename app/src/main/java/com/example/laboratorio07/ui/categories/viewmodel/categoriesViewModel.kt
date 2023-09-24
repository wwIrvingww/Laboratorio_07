package com.example.laboratorio07.ui.categories.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio07.networking.mealsApi
import com.example.laboratorio07.ui.categories.repository.categoriesRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class categoriesViewModel(
    private val repository: categoriesRepository = categoriesRepository(mealsApi.instance)
) : ViewModel() {
    var state by mutableStateOf(MainState())
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

    }
}
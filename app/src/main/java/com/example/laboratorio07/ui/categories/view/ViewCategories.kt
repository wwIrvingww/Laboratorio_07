package com.example.laboratorio07.ui.categories.view

import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.laboratorio07.ui.categories.viewmodel.CategoriesViewModel




@Composable
fun viewCateogories(viewModel: CategoriesViewModel) {
    val categories by viewModel.listCategories.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchCategories()
    }

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        categories?.let {
            items(it.categories) { category ->
                Button(
                    onClick = { /* Acción cuando se haga clic en el botón */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp) // Añadir relleno opcional si es necesario
                        .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Text(
                        text = category.strCategory,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}




package com.example.laboratorio07

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.laboratorio07.ui.categories.viewmodel.categoriesViewModel
import com.example.laboratorio07.ui.theme.Laboratorio07Theme
import androidx.compose.foundation.lazy.items
import com.example.laboratorio07.ui.categories.view.CategoryScreen

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<categoriesViewModel> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio07Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: categoriesViewModel) {
    val state = viewModel.state

    if(state.isloading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }

    if (state.categories.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(state.categories){
                Text(text = it.meals.toString())
            }
        }
    }

}

@Preview
@Composable
fun PreviewGreeting() {
    Greeting(viewModel = categoriesViewModel())
}





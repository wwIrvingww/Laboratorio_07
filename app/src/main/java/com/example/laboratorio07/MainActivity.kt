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
import com.example.laboratorio07.ui.categories.viewmodel.CategoriesViewModel
import com.example.laboratorio07.ui.theme.Laboratorio07Theme
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<CategoriesViewModel> ()
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
fun Greeting(viewModel: CategoriesViewModel) {
    val categories by viewModel.listCategories.observeAsState(null)

    LaunchedEffect(Unit){
        viewModel.fetchCategories()
    }

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        categories?.let {
            items(it.categories) {
                Text(text = it.strCategory)
                //Text(text = "API CONECTADA ")
            }
        }
    }


}




/**@Composable
fun Greeting(viewModel: CategoriesViewModel) {
    val state = viewModel.state

    if(state.isloading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }

    if (state.categories.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(state.categories){
                Text(text = it.category)
            }
        }
    }

}*/





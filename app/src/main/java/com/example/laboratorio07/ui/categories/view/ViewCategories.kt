package com.example.laboratorio07.ui.categories.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.laboratorio07.R
import com.example.laboratorio07.navigation.AppBar
import com.example.laboratorio07.navigation.NavigationState
import com.example.laboratorio07.navigation.navigateTo
import com.example.laboratorio07.networking.response.Category
import com.example.laboratorio07.ui.categories.viewmodel.CategoriesViewModel
import com.example.laboratorio07.ui.theme.EventIrvingAppTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(navController: NavController) {
    val viewModel: CategoriesViewModel = viewModel()
    val meals = viewModel.mealsState.value

    Scaffold(topBar = {
        AppBar(title = "Recepies", navController = navController)
    }) {
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            items(meals) { meal ->
                MealCategory(meal, navController)
            }
        }
    }
}

@Composable
fun MealCategory(meal: Category, navController: NavController) {
    Card(
        shape = RoundedCornerShape(8.dp),
        //elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row {
            /*Image(
                painter = rememberImagePainter(meal.strCategoryDescription),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
            )*/
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clickable {
                        meal.strCategory?.let {
                            navigateTo(
                                navController,
                                NavigationState.MealsRecepiesList.createRoute(it)
                            )
                        }
                    }
            ) {
                /*Text(
                    //text = (""),
                    text = meal.strCategoryDescription,
                    style = MaterialTheme.typography.headlineMedium
                )*/

                Text(
                    text =(""),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = meal.strCategory,
                    style = MaterialTheme.typography.headlineMedium
                    
                )
                Divider()

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EventIrvingAppTheme {
        MealsCategoriesScreen(navController = rememberNavController())
    }
}




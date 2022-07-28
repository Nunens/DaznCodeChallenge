package za.co.sikabopha.dazncodechallenge

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import za.co.sikabopha.dazncodechallenge.presentation.navigation.NavigationGraph
import za.co.sikabopha.dazncodechallenge.presentation.ui.components.BottomNavigationBar
import za.co.sikabopha.dazncodechallenge.presentation.viewmodel.DaznViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: DaznViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getEvents()
        viewModel.getSchedules()
        setContent {
            if (viewModel.eventState.value.isLoading){
                ProgressView()
            } else {
                MainScreenView(viewModel, applicationContext)
            }
        }
    }
}

@Composable
fun ProgressView(){
    Column(
        Modifier
            .fillMaxWidth(1F)
            .fillMaxHeight(1F),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun MainScreenView(vm: DaznViewModel, context: Context){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        NavigationGraph(navController = navController, vm, context)
    }
}
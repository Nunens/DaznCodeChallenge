package za.co.sikabopha.dazncodechallenge

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
            MainScreenView(viewModel, applicationContext)
        }
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
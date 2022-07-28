package za.co.sikabopha.dazncodechallenge

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ticker
import za.co.sikabopha.dazncodechallenge.presentation.navigation.NavigationGraph
import za.co.sikabopha.dazncodechallenge.presentation.ui.components.BottomNavigationBar
import za.co.sikabopha.dazncodechallenge.presentation.viewmodel.DaznViewModel
import java.time.LocalDateTime

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: DaznViewModel by viewModels()
    private lateinit var job: Deferred<Unit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getData()
        job = CoroutineScope(Dispatchers.IO).launchPeriodicAsync(30000) {
            getData()
        }

        setContent {
            if (viewModel.eventState.value.isLoading && !viewModel.eventState.value.firstLaunch) {
                ProgressView()
            } else if(viewModel.eventState.value.error.isNotEmpty()){
                ErrorView(error = viewModel.eventState.value.error)
            } else {
                MainScreenView(viewModel, applicationContext)
                viewModel.setLaunchState(true)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (job.isActive)
            job.cancel()
    }

    private fun CoroutineScope.launchPeriodicAsync(
        repeatMillis: Long,
        action: () -> Unit
    ) = this.async {
        if (repeatMillis > 0) {
            while (isActive) {
                action()
                delay(repeatMillis)
            }
        } else {
            action()
        }
    }

    private fun getData() {
        viewModel.getEvents()
        viewModel.getSchedules()
    }

    suspend fun startTimer() {
        val tickerChannel = ticker(delayMillis = 10_000, initialDelayMillis = 0)

        repeat(100) {
            tickerChannel.receive()
            getData()
        }
    }
}

@Composable
fun ProgressView() {
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
fun ErrorView(error: String) {
    Column(
        Modifier
            .fillMaxWidth(1F)
            .fillMaxHeight(1F),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = error)
    }
}

@Composable
fun MainScreenView(vm: DaznViewModel, context: Context) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        NavigationGraph(navController = navController, vm, context)
    }
}
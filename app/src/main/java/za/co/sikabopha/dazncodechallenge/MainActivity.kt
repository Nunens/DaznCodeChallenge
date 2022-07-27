package za.co.sikabopha.dazncodechallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import za.co.sikabopha.dazncodechallenge.presentation.EventState
import za.co.sikabopha.dazncodechallenge.presentation.ui.components.EventList
import za.co.sikabopha.dazncodechallenge.presentation.ui.theme.DAZNCodeChallengeTheme
import za.co.sikabopha.dazncodechallenge.presentation.viewmodel.DaznViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: DaznViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getEvents()
        //viewModel.getSchedules()
        setContent {
            val eventState: State<EventState> = viewModel.eventState
            DAZNCodeChallengeTheme {
                EventList(eventList = eventState.value.events, context = applicationContext)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DAZNCodeChallengeTheme {
        Greeting("Dazn")
    }
}
package za.co.sikabopha.dazncodechallenge.presentation.viewmodel

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import za.co.sikabopha.dazncodechallenge.domain.Resource
import za.co.sikabopha.dazncodechallenge.domain.repository.DaznRepository
import za.co.sikabopha.dazncodechallenge.presentation.EventState
import za.co.sikabopha.dazncodechallenge.presentation.ScheduleState
import za.co.sikabopha.dazncodechallenge.presentation.util.chromePlayer
import javax.inject.Inject

class DaznViewModel @Inject constructor(
    private val repository: DaznRepository
):ViewModel() {
    private val _eventState = mutableStateOf(EventState())
    val eventState: State<EventState> = _eventState

    private val _scheduleState = mutableStateOf(ScheduleState())
    val scheduleState: State<ScheduleState> = _scheduleState

    fun getEvents(){
        viewModelScope.launch {
            repository.getEvents()
                .collect{ response ->
                    when(response){
                        is Resource.Loading -> {
                            _eventState.value = eventState.value.copy(
                                isLoading = response.isLoading
                            )
                        }
                        is Resource.Success -> {
                            response.data?.let {
                                println("Events = $it")
                                _eventState.value = eventState.value.copy(
                                    events = it
                                )
                            }
                        }
                        else -> {
                            _eventState.value = eventState.value.copy(
                                error = response.message.toString()
                            )
                        }
                    }
                }
        }
    }

    fun getSchedules(){
        viewModelScope.launch {
            repository.getSchedule()
                .collect{ response ->
                    when(response){
                        is Resource.Loading -> {
                            _scheduleState.value = scheduleState.value.copy(
                                isLoading = response.isLoading
                            )
                        }
                        is Resource.Success -> {
                            response.data?.let {
                                println("Events = $it")
                                _scheduleState.value = scheduleState.value.copy(
                                    schedules = it
                                )
                            }
                        }
                        else -> {
                            _scheduleState.value = scheduleState.value.copy(
                                error = response.message.toString()
                            )
                        }
                    }
                }
        }
    }

    fun playVideo(url:String,context: Context){
        chromePlayer(url = url, context = context)
    }
}
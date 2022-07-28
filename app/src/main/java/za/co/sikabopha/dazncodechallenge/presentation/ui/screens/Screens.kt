package za.co.sikabopha.dazncodechallenge.presentation.ui.screens

import android.content.Context
import androidx.compose.runtime.Composable
import za.co.sikabopha.dazncodechallenge.presentation.viewmodel.DaznViewModel

@Composable
fun EventScreen(vm: DaznViewModel, context: Context) {
    //vm.getEvents()
    EventList(eventList = vm.eventState.value.events, context = context)
}

@Composable
fun ScheduleScreen(vm: DaznViewModel, context: Context) {
    //vm.getSchedules()
    ScheduleList(scheduleList = vm.scheduleState.value.schedules, context = context)
}
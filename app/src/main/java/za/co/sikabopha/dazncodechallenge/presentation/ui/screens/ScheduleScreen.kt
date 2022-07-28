package za.co.sikabopha.dazncodechallenge.presentation.ui.screens

import android.content.Context
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import za.co.sikabopha.dazncodechallenge.domain.model.Schedule
import za.co.sikabopha.dazncodechallenge.presentation.ui.components.ScheduleItem
import za.co.sikabopha.dazncodechallenge.presentation.viewmodel.DaznViewModel

@Composable
fun ScheduleScreen(vm: DaznViewModel, context: Context) {
    ScheduleList(scheduleList = vm.scheduleState.value.schedules, context = context)
}

@Composable
fun ScheduleList(scheduleList: List<Schedule>, context: Context) {
    LazyColumn {
        itemsIndexed(items = scheduleList) { _, item ->
            ScheduleItem(schedule = item, context = context)
        }
    }
}


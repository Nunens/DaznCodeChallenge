package za.co.sikabopha.dazncodechallenge.presentation.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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


package za.co.sikabopha.dazncodechallenge.presentation.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import za.co.sikabopha.dazncodechallenge.R
import za.co.sikabopha.dazncodechallenge.domain.model.Event
import za.co.sikabopha.dazncodechallenge.domain.model.Schedule
import za.co.sikabopha.dazncodechallenge.presentation.ui.components.EventList
import za.co.sikabopha.dazncodechallenge.presentation.ui.components.ScheduleList

@Composable
fun EventScreen(eventList: List<Event>, context: Context) {
    EventList(eventList = eventList, context = context)
}

@Composable
fun ScheduleScreen(scheduleList: List<Schedule>, context: Context) {
    ScheduleList(scheduleList = scheduleList, context = context)
}
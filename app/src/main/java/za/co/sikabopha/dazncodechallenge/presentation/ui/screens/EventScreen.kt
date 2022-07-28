package za.co.sikabopha.dazncodechallenge.presentation.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import za.co.sikabopha.dazncodechallenge.domain.model.Event
import za.co.sikabopha.dazncodechallenge.presentation.ui.components.EventItem
import za.co.sikabopha.dazncodechallenge.presentation.viewmodel.DaznViewModel

@Composable
fun EventScreen(vm: DaznViewModel, context: Context) {
    EventList(eventList = vm.eventState.value.events, context = context)
}

@Composable
fun EventList(eventList: List<Event>, context: Context) {
    LazyColumn(modifier = Modifier.padding(bottom = 55.dp)) {
        itemsIndexed(items = eventList) { _, item ->
            EventItem(event = item, context = context)
        }
    }
}


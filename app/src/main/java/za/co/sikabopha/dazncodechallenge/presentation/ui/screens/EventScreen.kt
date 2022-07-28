package za.co.sikabopha.dazncodechallenge.presentation.ui.screens

import android.content.Context
import androidx.compose.foundation.clickable
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
import za.co.sikabopha.dazncodechallenge.domain.model.Event
import za.co.sikabopha.dazncodechallenge.presentation.ui.components.EventItem
import za.co.sikabopha.dazncodechallenge.presentation.util.chromePlayer
import za.co.sikabopha.dazncodechallenge.presentation.viewmodel.DaznViewModel

@Composable
fun EventScreen(vm: DaznViewModel, context: Context) {
    EventList(eventList = vm.eventState.value.events, context = context)
}

@Composable
fun EventList(eventList: List<Event>, context: Context) {
    LazyColumn {
        itemsIndexed(items = eventList) { _, item ->
            EventItem(event = item, context = context)
        }
    }
}


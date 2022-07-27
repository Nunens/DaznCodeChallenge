package za.co.sikabopha.dazncodechallenge.presentation

import za.co.sikabopha.dazncodechallenge.data.dto.Event

data class EventState (
    val events: List<Event> = emptyList(),
    val error: String = "",
    val selectedIndex:Int = 0,
    val isLoading: Boolean = false
)
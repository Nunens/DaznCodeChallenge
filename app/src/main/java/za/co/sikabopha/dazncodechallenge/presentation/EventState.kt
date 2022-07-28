package za.co.sikabopha.dazncodechallenge.presentation

import za.co.sikabopha.dazncodechallenge.domain.model.Event

data class EventState (
    val events: List<Event> = emptyList(),
    val error: String = "",
    val selectedIndex:Int = 0,
    val isLoading: Boolean = false,
    var firstLaunch: Boolean = false
)
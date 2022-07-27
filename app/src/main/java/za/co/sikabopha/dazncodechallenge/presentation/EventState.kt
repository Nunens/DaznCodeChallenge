package za.co.sikabopha.dazncodechallenge.presentation

import za.co.sikabopha.dazncodechallenge.data.dto.EventDTO

data class EventState (
    val events: List<EventDTO> = emptyList(),
    val error: String = "",
    val selectedIndex:Int = 0,
    val isLoading: Boolean = false
)
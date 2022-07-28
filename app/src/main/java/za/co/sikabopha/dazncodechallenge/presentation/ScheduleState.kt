package za.co.sikabopha.dazncodechallenge.presentation

import za.co.sikabopha.dazncodechallenge.domain.model.Schedule

data class ScheduleState(
    val schedules: List<Schedule> = emptyList(),
    val error: String = "",
    val selectedIndex: Int = 0,
    val isLoading: Boolean = false,
    val firstLaunch: Boolean = false
)
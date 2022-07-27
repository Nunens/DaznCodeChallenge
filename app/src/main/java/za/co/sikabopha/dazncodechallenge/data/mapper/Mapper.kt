package za.co.sikabopha.dazncodechallenge.data.mapper

import za.co.sikabopha.dazncodechallenge.data.dto.Event
import za.co.sikabopha.dazncodechallenge.data.dto.EventDTO
import za.co.sikabopha.dazncodechallenge.data.dto.Schedule
import za.co.sikabopha.dazncodechallenge.data.dto.ScheduleDTO

fun EventDTO.toEvent():Event{
    return Event(
        title = title,
        subtitle = subtitle,
        date = date,
        imageUrl = imageUrl,
        videoUrl = videoUrl,
        formattedDate = "",
        timestamp = null,
    )
}
fun ScheduleDTO.toSchedule():Schedule{
    return Schedule(
        title = title,
        subtitle = subtitle,
        date = date,
        imageUrl = imageUrl,
        formattedDate = "",
        timestamp = null,
    )
}
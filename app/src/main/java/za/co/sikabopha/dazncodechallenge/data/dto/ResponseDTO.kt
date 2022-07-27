package za.co.sikabopha.dazncodechallenge.data.dto

data class ResponseDTO (
    val eventListDTO: List<EventDTO>?,
    val scheduleListDTO: List<ScheduleDTO>?
)
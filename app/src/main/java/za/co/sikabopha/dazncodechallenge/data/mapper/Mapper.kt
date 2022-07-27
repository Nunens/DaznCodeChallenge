package za.co.sikabopha.dazncodechallenge.data.mapper

import za.co.sikabopha.dazncodechallenge.data.dto.Event
import za.co.sikabopha.dazncodechallenge.data.dto.EventDTO
import za.co.sikabopha.dazncodechallenge.data.dto.Schedule
import za.co.sikabopha.dazncodechallenge.data.dto.ScheduleDTO

fun List<EventDTO>.toEvents(resp: List<EventDTO>):List<Event>{
    var convertedResp: List<Event>? = ArrayList()
    resp.forEach {
        convertedResp!!.plus(Event(it.title, it.subtitle, it.date, null, null, it.imageUrl, it.videoUrl))
    }
    return convertedResp!!
}
fun List<ScheduleDTO>.toSchedules(resp: List<ScheduleDTO>):List<Schedule>{
    var convertedResp: List<Schedule>? = ArrayList()
    resp.forEach {
        convertedResp!!.plus(Schedule(it.title, it.subtitle, it.date, null, null, it.imageUrl))
    }
    return convertedResp!!
}
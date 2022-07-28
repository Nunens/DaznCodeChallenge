package za.co.sikabopha.dazncodechallenge.data.remote

import retrofit2.http.GET
import za.co.sikabopha.dazncodechallenge.data.dto.EventDTO
import za.co.sikabopha.dazncodechallenge.data.dto.ScheduleDTO

interface DaznApi {
    companion object {
        const val BASE_URL = "https://us-central1-dazn-sandbox.cloudfunctions.net/"
    }

    @GET("getEvents")
    suspend fun getEvents(): List<EventDTO>

    @GET("getSchedule")
    suspend fun getSchedule(): List<ScheduleDTO>
}
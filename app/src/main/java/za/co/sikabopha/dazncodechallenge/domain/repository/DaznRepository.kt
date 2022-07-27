package za.co.sikabopha.dazncodechallenge.domain.repository

import kotlinx.coroutines.flow.Flow
import za.co.sikabopha.dazncodechallenge.data.dto.EventDTO
import za.co.sikabopha.dazncodechallenge.data.dto.ScheduleDTO
import za.co.sikabopha.dazncodechallenge.domain.Resource

interface DaznRepository {
    suspend fun getEvents(): Flow<Resource<List<EventDTO>>>

    suspend fun getSchedule():Flow<Resource<List<ScheduleDTO>>>
}
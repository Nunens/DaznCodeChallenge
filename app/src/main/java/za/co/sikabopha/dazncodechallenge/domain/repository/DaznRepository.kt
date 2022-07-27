package za.co.sikabopha.dazncodechallenge.domain.repository

import kotlinx.coroutines.flow.Flow
import za.co.sikabopha.dazncodechallenge.data.dto.Event
import za.co.sikabopha.dazncodechallenge.data.dto.Schedule
import za.co.sikabopha.dazncodechallenge.domain.Resource

interface DaznRepository {
    suspend fun getEvents(): Flow<Resource<out Any>>

    suspend fun getSchedule():Flow<Resource<out Any>>
}
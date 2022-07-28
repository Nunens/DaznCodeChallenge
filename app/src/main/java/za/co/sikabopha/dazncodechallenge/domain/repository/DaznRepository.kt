package za.co.sikabopha.dazncodechallenge.domain.repository

import kotlinx.coroutines.flow.Flow
import za.co.sikabopha.dazncodechallenge.domain.Resource
import za.co.sikabopha.dazncodechallenge.domain.model.Event
import za.co.sikabopha.dazncodechallenge.domain.model.Schedule

interface DaznRepository {
    suspend fun getEvents(): Flow<Resource<List<Event>>>

    suspend fun getSchedule(): Flow<Resource<List<Schedule>>>
}
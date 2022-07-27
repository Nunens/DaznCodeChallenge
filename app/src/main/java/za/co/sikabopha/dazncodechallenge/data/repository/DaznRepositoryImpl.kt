package za.co.sikabopha.dazncodechallenge.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import za.co.sikabopha.dazncodechallenge.data.dto.Event
import za.co.sikabopha.dazncodechallenge.data.dto.EventDTO
import za.co.sikabopha.dazncodechallenge.data.dto.Schedule
import za.co.sikabopha.dazncodechallenge.data.dto.ScheduleDTO
import za.co.sikabopha.dazncodechallenge.data.mapper.toEvents
import za.co.sikabopha.dazncodechallenge.data.mapper.toSchedules
import za.co.sikabopha.dazncodechallenge.data.remote.DaznApi
import za.co.sikabopha.dazncodechallenge.domain.Resource
import za.co.sikabopha.dazncodechallenge.domain.repository.DaznRepository
import java.io.IOException
import javax.inject.Inject

class DaznRepositoryImpl @Inject constructor(private val api: DaznApi): DaznRepository {
    override suspend fun getEvents(): Flow<Resource<List<EventDTO>>> {
        return flow {
            try {
                val resp = api.getEvents()
                println("Response = $resp")
                emit(Resource.Success(data = resp))
            } catch (e: HttpException) {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Error(message = "${e.message}"))
            } catch (e: IOException) {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Error(message = "${e.message}"))
            } catch (e: Exception) {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Error(message = "${e.message}"))
            }
        }
    }

    override suspend fun getSchedule(): Flow<Resource<List<ScheduleDTO>>> {
        return flow {
            try {
                val resp = api.getSchedule()
                println("Response = $resp")
                emit(Resource.Success(data = resp))
            } catch (e: HttpException) {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Error(message = "${e.message}"))
            } catch (e: IOException) {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Error(message = "${e.message}"))
            } catch (e: Exception) {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Error(message = "${e.message}"))
            }
        }
    }
}
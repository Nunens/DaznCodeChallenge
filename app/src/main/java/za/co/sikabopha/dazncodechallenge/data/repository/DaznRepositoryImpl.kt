package za.co.sikabopha.dazncodechallenge.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import za.co.sikabopha.dazncodechallenge.data.remote.DaznApi
import za.co.sikabopha.dazncodechallenge.domain.Resource
import za.co.sikabopha.dazncodechallenge.domain.model.Event
import za.co.sikabopha.dazncodechallenge.domain.model.Schedule
import za.co.sikabopha.dazncodechallenge.domain.repository.DaznRepository
import java.io.IOException
import javax.inject.Inject

class DaznRepositoryImpl @Inject constructor(private val api: DaznApi): DaznRepository {
    override suspend fun getEvents(): Flow<Resource<List<Event>>> {
        return flow {
            try {
                val resp = api.getEvents()
                val list: List<Event> = resp.map {
                    Event(it.title, it.subtitle, it.date, null, null, it.imageUrl, it.videoUrl)
                }
                println("Response[Event] = $resp")
                emit(Resource.Success(data = list))
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

    override suspend fun getSchedule(): Flow<Resource<List<Schedule>>> {
        return flow {
            try {
                val resp = api.getSchedule()
                val list: List<Schedule> = resp.map {
                    Schedule(it.title, it.subtitle, it.date, null, null, it.imageUrl)
                }
                println("Response[Schedule] = $resp")
                emit(Resource.Success(data = list))
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

    fun formatToDate(date: String): String{

        return ""
    }

    fun formatToTime(date: String): String{

        return ""
    }
}
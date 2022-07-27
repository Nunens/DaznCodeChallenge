package za.co.sikabopha.dazncodechallenge.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import za.co.sikabopha.dazncodechallenge.data.remote.DaznApi
import za.co.sikabopha.dazncodechallenge.domain.Resource
import za.co.sikabopha.dazncodechallenge.domain.model.Event
import za.co.sikabopha.dazncodechallenge.domain.model.Schedule
import za.co.sikabopha.dazncodechallenge.domain.repository.DaznRepository
import za.co.sikabopha.dazncodechallenge.domain.util.formatToDate
import za.co.sikabopha.dazncodechallenge.presentation.ui.components.ScheduleList
import java.io.IOException
import java.sql.Date
import java.text.SimpleDateFormat
import javax.inject.Inject

class DaznRepositoryImpl @Inject constructor(private val api: DaznApi): DaznRepository {
    override suspend fun getEvents(): Flow<Resource<List<Event>>> {
        return flow {
            try {
                val resp = api.getEvents()/*.sortedBy {
                    it.title
                }*/
                val list: List<Event> = resp.map {
                    Event(it.title, it.subtitle, it.date, it.imageUrl, it.videoUrl, null, null)
                }
                val newList = list.map { it ?: formatToDate(it.date) }
                println("NEW LIST: $newList")
                //println("Response[Event] = $list")
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
                /*val resp = api.getSchedule()
                val list: List<Schedule> = resp.map {
                    Schedule(it.id, it.title, it.subtitle, it.date, it.imageUrl, Date.valueOf(it.date), formatToDate(it.date))
                }
                println("Response[Schedule] = $list")
                emit(Resource.Success(data = resp))*/
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
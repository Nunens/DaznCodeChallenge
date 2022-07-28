package za.co.sikabopha.dazncodechallenge.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import za.co.sikabopha.dazncodechallenge.data.remote.DaznApi
import za.co.sikabopha.dazncodechallenge.domain.Resource
import za.co.sikabopha.dazncodechallenge.domain.model.Event
import za.co.sikabopha.dazncodechallenge.domain.model.Schedule
import za.co.sikabopha.dazncodechallenge.domain.repository.DaznRepository
import java.io.IOException
import java.text.SimpleDateFormat
import java.time.Clock
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class DaznRepositoryImpl @Inject constructor(private val api: DaznApi): DaznRepository {
    override suspend fun getEvents(): Flow<Resource<List<Event>>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val resp = api.getEvents()
                val list: List<Event> = resp.map {
                    Event(it.title, it.subtitle, it.date, it.imageUrl, it.videoUrl, java.util.Date(), it.date)
                }.sortedBy { it.date }
                emit(Resource.Success(data = list))
                emit(Resource.Loading(isLoading = false))
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
                emit(Resource.Loading(isLoading = true))
                val resp = api.getSchedule()
                val list: List<Schedule> = resp.map {
                    Schedule(it.id, it.title, it.subtitle, it.date, it.imageUrl, java.util.Date(), it.date)
                }.sortedBy { it.date }
                emit(Resource.Success(data = list))
                emit(Resource.Loading(isLoading = false))
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

    suspend fun formatToDate(date: String): String {
        var formattedDate: String = ""
        runBlocking {
            val pattern: String = "yyyy-MM-dd"
            val simpleDateFormat: SimpleDateFormat = SimpleDateFormat(pattern)
            formattedDate = simpleDateFormat.format(date)
            println(formattedDate)
        }
        return formattedDate
    }

    fun formatToTime(date: String): String {
        val pattern: String = "HH:mm"
        val simpleDateFormat: SimpleDateFormat = SimpleDateFormat(pattern)
        var formattedDate: String = simpleDateFormat.format(date)
        println(formattedDate)
        return formattedDate
    }
}
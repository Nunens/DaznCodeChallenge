package za.co.sikabopha.dazncodechallenge.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import za.co.sikabopha.dazncodechallenge.data.mapper.toEvents
import za.co.sikabopha.dazncodechallenge.data.mapper.toSchedules
import za.co.sikabopha.dazncodechallenge.data.remote.DaznApi
import za.co.sikabopha.dazncodechallenge.domain.Resource
import za.co.sikabopha.dazncodechallenge.domain.repository.DaznRepository
import java.io.IOException
import javax.inject.Inject

class DaznRepositoryImpl @Inject constructor(private val api: DaznApi): DaznRepository {
    override suspend fun getEvents(): Flow<Resource<out Any>> {
        return flow {
            try {
                val resp = api.getEvents()
                emit(Resource.Success(data = resp.toEvents(resp)))
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

    override suspend fun getSchedule(): Flow<Resource<out Any>> {
        return flow {
            try {
                val resp = api.getSchedule()
                emit(Resource.Success(data = resp.toSchedules(resp)))
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
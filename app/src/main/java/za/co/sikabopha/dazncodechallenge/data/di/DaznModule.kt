package za.co.sikabopha.dazncodechallenge.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import za.co.sikabopha.dazncodechallenge.data.remote.DaznApi
import za.co.sikabopha.dazncodechallenge.data.repository.DaznRepositoryImpl
import za.co.sikabopha.dazncodechallenge.domain.repository.DaznRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaznModule {

    @Provides
    @Singleton
    fun provideDaznApi():DaznApi{
        return Retrofit.Builder()
            .baseUrl(DaznApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DaznApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDaznRepository(api: DaznApi):DaznRepository{
        return DaznRepositoryImpl(api)
    }
}
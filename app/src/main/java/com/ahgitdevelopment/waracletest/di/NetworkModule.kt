package com.ahgitdevelopment.waracletest.di

import com.ahgitdevelopment.waracletest.network.CakeService
import com.ahgitdevelopment.waracletest.network.CakesApi
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun getCakeServiceImp(): CakeService {
        return CakesApi.retrofitService
    }

}
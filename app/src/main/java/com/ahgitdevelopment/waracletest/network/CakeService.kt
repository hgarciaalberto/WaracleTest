package com.ahgitdevelopment.waracletest.network

import com.ahgitdevelopment.waracletest.common.BASE_URL
import com.ahgitdevelopment.waracletest.common.CAKES_URL
import com.ahgitdevelopment.waracletest.data.CakeScheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface CakeService {
    @GET(CAKES_URL)
    suspend fun getCakeList(): ArrayList<CakeScheme>
}

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


object CakesApi {
    val retrofitService: CakeService by lazy { retrofit.create(CakeService::class.java) }
}

package com.ahgitdevelopment.waracletest.ui.main

import com.ahgitdevelopment.waracletest.data.CakeScheme
import com.ahgitdevelopment.waracletest.network.CakeService
import com.ahgitdevelopment.waracletest.testutils.COMPLETE_LIST


class CakeServiceTd : CakeService {

    var response = Response.VALID

    override suspend fun getCakeList(): ArrayList<CakeScheme> {
        if (response == Response.VALID)
            return COMPLETE_LIST
        else
            throw Exception("Communication problem")
    }
}

enum class Response {
    VALID,
    ERROR
}
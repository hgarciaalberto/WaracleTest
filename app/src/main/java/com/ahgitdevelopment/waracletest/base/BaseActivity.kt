package com.ahgitdevelopment.waracletest.base

import androidx.appcompat.app.AppCompatActivity
import com.ahgitdevelopment.waracletest.factory.ViewModelFactory
import com.ahgitdevelopment.waracletest.network.CakeService
import javax.inject.Inject


open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var serviceApi: CakeService

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
}


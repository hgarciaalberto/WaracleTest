package com.ahgitdevelopment.waracletest.base

import androidx.multidex.MultiDexApplication
import com.ahgitdevelopment.waracletest.di.ApplicationComponent
import com.ahgitdevelopment.waracletest.di.DaggerApplicationComponent

open class BaseApplication : MultiDexApplication() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    private val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return appComponent
    }
}

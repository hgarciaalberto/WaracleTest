package com.ahgitdevelopment.waracletest.di

import com.ahgitdevelopment.waracletest.base.BaseApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private var mApplication: BaseApplication) {

    @Provides
    fun getApplication(): BaseApplication {
        return mApplication
    }
}

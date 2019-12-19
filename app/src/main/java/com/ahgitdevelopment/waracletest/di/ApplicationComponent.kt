package com.ahgitdevelopment.waracletest.di

import com.ahgitdevelopment.waracletest.base.BaseApplication
import com.ahgitdevelopment.waracletest.ui.main.MainFragment
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        ApplicationModule::class,
        ViewModelFactoryModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent {

    fun inject(application: BaseApplication)

    fun inject(mainFragment: MainFragment)


}
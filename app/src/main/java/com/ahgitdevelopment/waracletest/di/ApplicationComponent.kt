package com.ahgitdevelopment.waracletest.di

import com.ahgitdevelopment.waracletest.base.BaseApplication
import com.ahgitdevelopment.waracletest.base.BaseFragment
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

    fun inject(baseFragment: BaseFragment)

}

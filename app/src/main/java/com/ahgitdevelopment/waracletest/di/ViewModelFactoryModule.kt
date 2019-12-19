package com.ahgitdevelopment.waracletest.di

import com.ahgitdevelopment.waracletest.factory.ViewModelFactory
import com.ahgitdevelopment.waracletest.ui.main.MainViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class ViewModelFactoryModule {
    @Provides
    fun viewModelFactory(
        mainViewModelProvider: Provider<MainViewModel>
    ): ViewModelFactory {
        return ViewModelFactory(mainViewModelProvider)
    }

    @Provides
    fun getMainViewModel(): MainViewModel {
        return MainViewModel()
    }

}
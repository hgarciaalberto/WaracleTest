package com.ahgitdevelopment.waracletest.di

import com.ahgitdevelopment.waracletest.factory.ViewModelFactory
import com.ahgitdevelopment.waracletest.ui.main.MainFragmentViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class ViewModelFactoryModule {
    @Provides
    fun viewModelFactory(
        mainFragmentViewModelProvider: Provider<MainFragmentViewModel>
    ): ViewModelFactory {
        return ViewModelFactory(mainFragmentViewModelProvider)
    }

    @Provides
    fun getMainViewModel(): MainFragmentViewModel {
        return MainFragmentViewModel()
    }
}
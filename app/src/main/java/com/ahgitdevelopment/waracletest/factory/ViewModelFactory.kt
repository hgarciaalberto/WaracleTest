package com.ahgitdevelopment.waracletest.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahgitdevelopment.waracletest.ui.main.MainViewModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(mainViewModelProvider: Provider<MainViewModel>) :
    ViewModelProvider.Factory {

    private var mMainViewModelProvider: Provider<MainViewModel> = mainViewModelProvider

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MainViewModel::class.java -> mMainViewModelProvider.get() as T

            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

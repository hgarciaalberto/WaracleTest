package com.ahgitdevelopment.waracletest.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahgitdevelopment.waracletest.ui.main.MainFragmentViewModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(mainFragmentViewModelProvider: Provider<MainFragmentViewModel>) :
    ViewModelProvider.Factory {

    private var mMainFragmentViewModelProvider: Provider<MainFragmentViewModel> = mainFragmentViewModelProvider

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MainFragmentViewModel::class.java -> mMainFragmentViewModelProvider.get() as T

            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

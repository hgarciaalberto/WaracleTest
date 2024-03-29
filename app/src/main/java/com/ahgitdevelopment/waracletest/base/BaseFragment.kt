package com.ahgitdevelopment.waracletest.base

import androidx.annotation.UiThread
import androidx.fragment.app.Fragment
import com.ahgitdevelopment.waracletest.di.ApplicationComponent
import com.ahgitdevelopment.waracletest.factory.ViewModelFactory
import com.ahgitdevelopment.waracletest.network.CakeService
import javax.inject.Inject

open class BaseFragment : Fragment() {

    @Inject
    lateinit var serviceApi: CakeService

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @UiThread
    fun getApplicationComponent(): ApplicationComponent {
        return (activity?.application as BaseApplication).getApplicationComponent()
    }
}
package com.ahgitdevelopment.waracletest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahgitdevelopment.waracletest.data.Cake
import com.ahgitdevelopment.waracletest.network.CakeService
import kotlinx.coroutines.launch

class MainFragmentViewModel : ViewModel() {
    private val _cakeList = MutableLiveData<List<Cake>>()
    val cakeList: LiveData<List<Cake>> = _cakeList


    fun getCakeList(serviceApi: CakeService) {

        viewModelScope.launch {
            serviceApi.getCakeList().let {
                _cakeList.value = Cake.parseSchemeToBusinessData(it)
            }
        }
    }
}

package com.ahgitdevelopment.waracletest.ui.main

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahgitdevelopment.waracletest.data.Cake
import com.ahgitdevelopment.waracletest.network.CakeService
import kotlinx.coroutines.launch

@Suppress("PropertyName")
class MainFragmentViewModel : ViewModel() {
    private val _cakeList = MutableLiveData<List<Cake>>()
    val cakeList: LiveData<List<Cake>> = _cakeList

    private val _loading = MutableLiveData<Int>()
    val loading: LiveData<Int> = _loading

    private val _emptyList = MutableLiveData<Int>()
    val emptyList: LiveData<Int> = _emptyList

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    init {
        _cakeList.value = ArrayList()
        _loading.value = View.GONE
        _emptyList.value = View.VISIBLE
    }


    fun getCakeList(serviceApi: CakeService) {

        viewModelScope.launch {
            _loading.value = View.VISIBLE
            try {
                serviceApi.getCakeList().let {
                    _cakeList.value = Cake.parseSchemeToBusinessData(it)
                    _emptyList.value = if (it.size != 0) View.GONE else View.VISIBLE
                }
            } catch (e: Exception) {
                _errorMessage.value = "Cakes not loaded"
            } finally {
                _loading.value = View.GONE
            }
        }
    }
}

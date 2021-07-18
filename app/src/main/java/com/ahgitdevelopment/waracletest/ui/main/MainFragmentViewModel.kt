package com.ahgitdevelopment.waracletest.ui.main

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahgitdevelopment.waracletest.common.SingleLiveEvent
import com.ahgitdevelopment.waracletest.data.Cake
import com.ahgitdevelopment.waracletest.data.processList
import com.ahgitdevelopment.waracletest.data.toBusinessData
import com.ahgitdevelopment.waracletest.network.CakeService
import kotlinx.coroutines.launch

@Suppress("PropertyName")
class MainFragmentViewModel : ViewModel() {
    /**
     * List of elements in the UI
     */
    private val _cakeList = MutableLiveData<List<Cake>>()
    val cakeList: LiveData<List<Cake>> = _cakeList

    /**
     * ContentLoadingProgressBar in the xml to show the loading time
     */
    private val _loading = MutableLiveData<Int>()
    val loading: LiveData<Int> = _loading

    /**
     * Message when list of cakes is empty
     */
    private val _emptyList = MutableLiveData<Int>()
    val emptyList: LiveData<Int> = _emptyList

    /**
     * Observable in charge of showing the Snackbar when loading error happened.
     * The snackbar only has to show once per fail so SingleLiveEvent class is needed
     */
    val showError = SingleLiveEvent<Boolean>()

    /**
     * Initialization of UI elements
     */
    init {
        _cakeList.value = ArrayList()
        _loading.value = View.GONE
        _emptyList.value = View.VISIBLE
    }

    /**
     * Get list of elements using Coroutines and retrofit to obtain the response without blocking the UI.
     * It also process the list obtained to remove duplicate and sort elements
     * @param serviceApi Parameter with retrofit service API configuration
     */
    fun getCakeList(serviceApi: CakeService) {

        viewModelScope.launch {
            _loading.value = View.VISIBLE
            try {
                serviceApi.getCakeList().let { cakeSchemeList ->

                    // Process list to remove duplicates and sort list
                    cakeSchemeList.processList()

                    // Update UI elements
                    _cakeList.value = cakeSchemeList.map { it.toBusinessData() }
                    _emptyList.value = if (cakeSchemeList.size != 0) View.GONE else View.VISIBLE
                }
            } catch (e: Exception) {
                showError.value = true
            } finally {
                _loading.value = View.GONE
            }
        }
    }
}

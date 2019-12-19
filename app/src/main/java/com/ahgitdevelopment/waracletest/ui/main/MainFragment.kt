package com.ahgitdevelopment.waracletest.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.ahgitdevelopment.waracletest.R
import com.ahgitdevelopment.waracletest.base.BaseFragment
import com.ahgitdevelopment.waracletest.network.CakeService
import javax.inject.Inject

class MainFragment : BaseFragment() {

    @Inject
    lateinit var serviceApi: CakeService

    private lateinit var fragmentViewModel: MainFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getApplicationComponent().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fragmentViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainFragmentViewModel::class.java)
        // TODO: Use the ViewModel
        fragmentViewModel.getCakeList(serviceApi)
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}

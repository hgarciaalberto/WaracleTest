package com.ahgitdevelopment.waracletest.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahgitdevelopment.waracletest.R
import com.ahgitdevelopment.waracletest.base.BaseFragment
import com.ahgitdevelopment.waracletest.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment() {

    private lateinit var fragmentViewModel: MainFragmentViewModel

    private var recyclerViewAdapter: CakeRecyclerViewAdaper? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getApplicationComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentBinding: MainFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false
        )

        fragmentViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainFragmentViewModel::class.java)
        fragmentBinding.apply {
            lifecycleOwner = activity
            model = fragmentViewModel
        }

        return fragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupList()
    }

    fun setupList() {
        fragmentViewModel.getCakeList(serviceApi)
        fragmentViewModel.cakeList.observe(this, Observer {
            recyclerViewAdapter = CakeRecyclerViewAdaper(it)

            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                adapter = recyclerViewAdapter
            }
        })
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}

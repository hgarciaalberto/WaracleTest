package com.ahgitdevelopment.waracletest.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahgitdevelopment.waracletest.R
import com.ahgitdevelopment.waracletest.base.BaseFragment
import com.ahgitdevelopment.waracletest.common.TAG_CAKE_DIALOG_FRAGMENT
import com.ahgitdevelopment.waracletest.data.Cake
import com.ahgitdevelopment.waracletest.databinding.MainFragmentBinding
import com.ahgitdevelopment.waracletest.ui.dialog.CakeDialogFragment
import com.google.android.material.snackbar.Snackbar

class MainFragment : BaseFragment(), CakeViewHolder.OnItemClickListener {

    private val fragmentViewModel: MainFragmentViewModel by viewModels()

    private var recyclerViewAdapter: CakeRecyclerViewAdapter? = null

    private var snackbar: Snackbar? = null

    private lateinit var fragmentBinding: MainFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getApplicationComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false
        )

        fragmentBinding.apply {
            lifecycleOwner = activity
            model = fragmentViewModel
        }

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchCakeList()

        fragmentViewModel.cakeList.observe(viewLifecycleOwner, Observer {
            recyclerViewAdapter = CakeRecyclerViewAdapter(it, this)

            fragmentBinding.recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                adapter = recyclerViewAdapter
            }
        })

        fragmentViewModel.showError.observe(viewLifecycleOwner, Observer { showError ->
            activity?.findViewById<View>(R.id.mainFragmentLayout)?.let { view ->
                if (showError == true) {
                    snackbar = Snackbar.make(view, R.string.error_message, Snackbar.LENGTH_INDEFINITE)
                        .setAction(R.string.refresh) { fragmentViewModel.getCakeList(serviceApi) }
                    snackbar?.show()
                }
            }
        })
    }

    fun fetchCakeList() {
        snackbar?.dismiss()
        fragmentViewModel.getCakeList(serviceApi)
    }

    override fun onItemClickListener(item: Cake) {
        val newFragment = CakeDialogFragment.newInstance(item)
        newFragment.show(parentFragmentManager, TAG_CAKE_DIALOG_FRAGMENT)
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}

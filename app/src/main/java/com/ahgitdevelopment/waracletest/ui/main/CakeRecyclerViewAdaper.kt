package com.ahgitdevelopment.waracletest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahgitdevelopment.waracletest.BR
import com.ahgitdevelopment.waracletest.R
import com.ahgitdevelopment.waracletest.data.Cake
import com.ahgitdevelopment.waracletest.databinding.ItemCakeBinding


class CakeRecyclerViewAdaper(private val cakeList: List<Cake>) : RecyclerView.Adapter<CakeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val itemBinding: ItemCakeBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_cake, parent, false
        )

        return CakeViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return cakeList.size
    }

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        val item: Cake = cakeList[position]
        holder.bind(item)
    }
}

class CakeViewHolder(private val binding: ItemCakeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Cake) {
        // Used when there is only one Binding (easiest way)
//        binding.modelCake = item

        //It can be assigned whatever view model object type I need (harder way)
        binding.setVariable(BR.modelCake, item)

        binding.executePendingBindings()
    }
}
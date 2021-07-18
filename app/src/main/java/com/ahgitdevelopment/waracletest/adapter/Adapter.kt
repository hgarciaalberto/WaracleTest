package com.ahgitdevelopment.waracletest.adapter

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.ahgitdevelopment.waracletest.R
import com.bumptech.glide.Glide

@SuppressLint("UseCompatLoadingForDrawables")
@BindingAdapter("imageUrlAdapter")
fun bindImageUrlAdapter(imageView: ImageView, imageUrl: String?) {

    if (imageView.getTag(R.id.imageView) == null || imageView.getTag(R.id.imageView) != imageUrl) {
        imageView.setImageBitmap(null)
        imageView.setTag(R.id.imageView, imageUrl)
        Glide.with(imageView)
            .load(imageUrl)
            .placeholder(
                with(imageView.context) {
                    resources.getDrawable(R.mipmap.ic_launcher, theme)
                }
            )
            .into(imageView)
    }
}
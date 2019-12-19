package com.ahgitdevelopment.waracletest.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.ahgitdevelopment.waracletest.R
import com.bumptech.glide.Glide

@BindingAdapter("imageUrlAdapter")
fun bindImageUrlAdapter(imageView: ImageView, imageUrl: String?) {
    // If we don't do this, you'll see the old image appear briefly
    if (imageUrl != null) {
        // before it's replaced with the current image
        if (imageView.getTag(R.id.imageView) == null || imageView.getTag(R.id.imageView) != imageUrl) {
            imageView.setImageBitmap(null)
            imageView.setTag(R.id.imageView, imageUrl)
            Glide.with(imageView).load(imageUrl).into(imageView)
        }
    } else {
        imageView.setTag(R.id.imageView, null)
        imageView.setImageBitmap(null) // TODO: Show a better image
    }
}
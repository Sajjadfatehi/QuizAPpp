package com.example.quizapp.util

import android.graphics.Color
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.google.android.material.card.MaterialCardView

@BindingAdapter(value = ["bind:url"], requireAll = true)
fun loadImage(view: View, url: String?) {
    view as AppCompatImageView
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context).load(url)
            .transform(CircleCrop()).into(view)
    } else {
        Glide.with(view.context)
            .clear(view)
        // remove the placeholder (optional); read comments below
        view.setImageDrawable(null)
    }


}
@BindingAdapter(value = ["bind:numberOfDeaths"], requireAll = true)
fun setBackGroundColor(view: View, numberOfDeaths: Int?) {
    view as MaterialCardView

    if (numberOfDeaths != null) {
        if (numberOfDeaths>20000){
            view.setBackgroundColor(Color.RED)
        } else if (numberOfDeaths>10000){
            view.setBackgroundColor(Color.YELLOW)

        }
        else view.setBackgroundColor(Color.GREEN)


    }
}



fun loadImage(imageView: AppCompatImageView, rec: Int) {
    Glide.with(imageView.context).load(rec).into(imageView)
}

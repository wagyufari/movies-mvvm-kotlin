package com.nacoda.moviesmvvm.util.helper

import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.support.v7.widget.CardView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import java.util.*

/**
 * Created by Mayburger on 12/21/17.
 */
fun getGenres(data: Array<String>): String {
    return Arrays.toString(data)
            .replace("28", "Action").replace("27", "Horror").replace("12", "Adventure").replace("16", "Animation").replace("35", "Comedy").replace("80", "Crime").replace("99", "Documentary").replace("18", "Drama").replace("14", "Fantasy").replace("10402", "Music").replace("9648", "Mystery").replace("10749", "Romance").replace("878", "Science Fiction").replace("10770", "TV Movie").replace("10752", "War").replace("37", "Western").replace("10751", "Family").replace("53", "Thriller").replace("[", "").replace("]", "")
}

@BindingAdapter("bind:imageUrl")
fun loadImage(view: CardView, url: String) {
    Glide.with(view.context).load(url).asBitmap().into(object : SimpleTarget<Bitmap>(400, 400) {
        override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {
            val drawable = BitmapDrawable(resource)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                view.foreground = drawable
            }
        }
    })
}
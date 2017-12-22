package com.nacoda.moviesmvvm.util.helper

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import java.util.*

/**
 * Created by Mayburger on 12/21/17.
 */
fun getGenres(data: Array<String>): String {
    return Arrays.toString(data)
            .replace("28", "Action").replace("27", "Horror").replace("12", "Adventure").replace("16", "Animation").replace("35", "Comedy").replace("80", "Crime").replace("99", "Documentary").replace("18", "Drama").replace("14", "Fantasy").replace("10402", "Music").replace("9648", "Mystery").replace("10749", "Romance").replace("878", "Science Fiction").replace("10770", "TV Movie").replace("10752", "War").replace("37", "Western").replace("10751", "Family").replace("53", "Thriller").replace("[", "").replace("]", "")
}

@BindingAdapter("bind:loadPoster")
fun loadPoster(view: ImageView, url: String) {
    Glide.with(view.context).load(url).apply(RequestOptions().centerCrop()).transition(DrawableTransitionOptions.withCrossFade()).into(view)
}
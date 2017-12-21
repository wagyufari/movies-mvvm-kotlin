package com.nacoda.moviesmvvm.mvvm

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.nacoda.moviesmvvm.data.model.Movie

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

object MainMoviesBindings {

    @BindingAdapter("app:movieList")
    @JvmStatic
    fun setMovieList(recyclerView: RecyclerView, movies: List<Movie>) {

        with(recyclerView.adapter as MainMoviesAdapter) {
            replaceData(movies)
        }
    }
}
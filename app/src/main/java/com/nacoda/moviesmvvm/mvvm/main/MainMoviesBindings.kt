package com.nacoda.moviesmvvm.mvvm.main

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.PopularAdapter
import com.nacoda.moviesmvvm.mvvm.main.movies.top.TopAdapter

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

object MainMoviesBindings {

    @BindingAdapter("app:popularList")
    @JvmStatic
    fun setPopularList(recyclerView: RecyclerView, movies: List<Movie>) {

        with(recyclerView.adapter as PopularAdapter) {
            replaceData(movies)
        }
    }

    @BindingAdapter("app:topList")
    @JvmStatic
    fun setTopList(recyclerView: RecyclerView, movies: List<Movie>) {

        with(recyclerView.adapter as TopAdapter) {
            replaceData(movies)
        }
    }
}
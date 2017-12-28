package com.nacoda.moviesmvvm.mvvm.main.search

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableInt
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.data.source.MoviesDataSource
import com.nacoda.moviesmvvm.data.source.MoviesRepository
import com.nacoda.moviesmvvm.util.helper.hideProgress
import com.nacoda.moviesmvvm.util.helper.showProgress

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class SearchViewModel(context: Application, private val mMoviesRepository: MoviesRepository) : AndroidViewModel(context) {

    @SuppressLint("StaticFieldLeak")
    var mContext = context

    var progressVisibility = ObservableInt()
    var recyclerVisibility = ObservableInt()
    var errorTextVisibility = ObservableInt()

    fun start(query: String, recyclerViewSearch: RecyclerView) {
        getQueryMovie(query, recyclerViewSearch)
    }

    fun getQueryMovie(query: String, recyclerViewSearch: RecyclerView) {
        mMoviesRepository.getSearch(object : MoviesDataSource.GetMoviesCallback {
            override fun onMoviesLoaded(movies: List<Movie>?) {

                showProgress(progressVisibility, recyclerVisibility)

                val mAdapter = SearchAdapter(movies, this@SearchViewModel, mContext)

                val layoutManager = LinearLayoutManager(mContext)
                layoutManager.orientation = LinearLayoutManager.VERTICAL

                with(recyclerViewSearch) {
                    adapter = mAdapter
                    setLayoutManager(layoutManager)
                }
            }

            override fun onDataNotAvailable() {
                hideProgress(progressVisibility, recyclerVisibility, errorTextVisibility)
            }

            override fun onError(errorMessage: String?) {
                hideProgress(progressVisibility, recyclerVisibility)
            }
        }, query)
    }


}



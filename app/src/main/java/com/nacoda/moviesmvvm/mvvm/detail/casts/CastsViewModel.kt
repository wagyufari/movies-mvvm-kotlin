package com.nacoda.moviesmvvm.mvvm.detail.casts

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableInt
import android.databinding.ObservableList
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.nacoda.moviesmvvm.data.model.Casts
import com.nacoda.moviesmvvm.data.model.Detail
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.data.source.MoviesDataSource
import com.nacoda.moviesmvvm.data.source.MoviesRepository
import id.gits.jasaraharja.util.SingleLiveEvent

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class CastsViewModel(context: Application, private val mMoviesRepository: MoviesRepository) : AndroidViewModel(context) {


    @SuppressLint("StaticFieldLeak")
    var mContext = context

    var progressVisibility = ObservableInt()
    var recyclerVisibility = ObservableInt()

    fun start(mMovie: Movie, recyclerViewCasts: RecyclerView) {
        getCasts(mMovie, recyclerViewCasts)
    }

    fun getCasts(mMovie: Movie, recyclerViewCasts:RecyclerView) {
        mMoviesRepository.getCasts(object : MoviesDataSource.GetCastsCallback {
            override fun onCastsLoaded(casts: Casts) {

                progressVisibility.set(View.GONE)
                recyclerVisibility.set(View.VISIBLE)

                val mAdapter = CastsAdapter(casts, this@CastsViewModel, mContext)
                val layoutManager = LinearLayoutManager(mContext)
                layoutManager.orientation = LinearLayoutManager.VERTICAL

                with(recyclerViewCasts){
                    adapter = mAdapter
                    setLayoutManager(layoutManager)
                    isNestedScrollingEnabled = false
                }

            }

            override fun onDataNotAvailable() {
            }

            override fun onError(errorMessage: String?) {
                if (errorMessage != null) {
                }
            }

        }, mMovie.id.toString())
    }

}



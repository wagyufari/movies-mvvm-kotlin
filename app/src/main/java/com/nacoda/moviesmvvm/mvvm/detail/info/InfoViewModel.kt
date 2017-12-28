package com.nacoda.moviesmvvm.mvvm.detail.info

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
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
import com.nacoda.moviesmvvm.mvvm.detail.casts.CastsAdapter
import id.gits.jasaraharja.util.SingleLiveEvent

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class InfoViewModel(context: Application, private val mMoviesRepository: MoviesRepository) : AndroidViewModel(context) {


    @SuppressLint("StaticFieldLeak")
    var mContext = context

    var backdrop_path = ObservableField<String>()
    var budget = ObservableField<String>()
    var overview = ObservableField<String>()
    var revenue = ObservableField<String>()
    var runtime = ObservableField<String>()
    var vote_average = ObservableField<String>()
    var vote_count = ObservableField<String>()

    fun start(mMovie: Movie) {
        getInfo(mMovie)
    }

    fun getInfo(mMovie: Movie) {
        mMoviesRepository.getDetail(object : MoviesDataSource.GetDetailCallback {
            override fun onDetailLoaded(detail: Detail?) {

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



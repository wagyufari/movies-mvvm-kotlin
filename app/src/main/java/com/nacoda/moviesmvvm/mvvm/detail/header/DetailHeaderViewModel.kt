package com.nacoda.moviesmvvm.mvvm.detail.header

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.data.source.MoviesDataSource
import com.nacoda.moviesmvvm.data.source.MoviesRepository
import com.nacoda.moviesmvvm.databinding.DetailHeaderFragmentBinding
import id.gits.jasaraharja.util.SingleLiveEvent

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class DetailHeaderViewModel(context: Application, private val mMoviesRepository: MoviesRepository) : AndroidViewModel(context) {

    val movieList: ObservableList<Movie> = ObservableArrayList()
    internal val mOpenMovieDetail = SingleLiveEvent<Movie>()
    @SuppressLint("StaticFieldLeak")
    var mContext = context

    fun start(mMovie:Movie) {

    }

}



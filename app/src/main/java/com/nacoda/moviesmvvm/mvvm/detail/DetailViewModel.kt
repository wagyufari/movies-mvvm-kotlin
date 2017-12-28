package com.nacoda.moviesmvvm.mvvm.detail

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.widget.Toast
import com.nacoda.moviesmvvm.data.model.Detail
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.data.source.MoviesDataSource
import com.nacoda.moviesmvvm.data.source.MoviesRepository
import id.gits.jasaraharja.util.SingleLiveEvent

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class DetailViewModel(context: Application, private val mMoviesRepository: MoviesRepository) : AndroidViewModel(context) {

    @SuppressLint("StaticFieldLeak")
    var mContext = context
}



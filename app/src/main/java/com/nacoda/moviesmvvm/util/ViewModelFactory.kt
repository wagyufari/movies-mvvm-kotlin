package com.nacoda.moviesmvvm.util

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nacoda.moviesmvvm.data.source.MoviesRepository
import com.nacoda.moviesmvvm.mvvm.MainViewModel

/**
 * Created by irfanirawansukirman on 04/12/17.
 */
class ViewModelFactory private constructor(
        private val mApplication: Application,
        private val mMoviesRepository: MoviesRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(MainViewModel::class.java) ->
                        MainViewModel(mApplication, mMoviesRepository)
                    else ->
                        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(mApplication: Application) =
                INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE ?: ViewModelFactory(mApplication,
                            Injection.provideMoviesRepository(mApplication.applicationContext))
                            .also { INSTANCE = it }
                }
    }
}
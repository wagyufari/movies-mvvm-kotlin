package com.nacoda.moviesmvvm.data.source.remote

import com.nacoda.moviesmvvm.data.source.MoviesDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

object MoviesRemoteDataSource : MoviesDataSource {

    private val mApiService = MoviesService.create()
    private lateinit var mMovieId: String

    override fun saveMovieId(movieId: String) {
        mMovieId = movieId
    }

    override fun getMovieId(): String {
        return mMovieId
    }

    override fun getMovies(callback: MoviesDataSource.GetMoviesCallback) {
        mApiService.getMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ results ->
                    run {
                        if (results.results!!.isNotEmpty()) {
                            callback.onMoviesLoaded(results?.results)
                        } else {
                            callback.onDataNotAvailable()
                        }
                    }
                }, { error ->
                    callback.onError(error.message)
                })
    }
}
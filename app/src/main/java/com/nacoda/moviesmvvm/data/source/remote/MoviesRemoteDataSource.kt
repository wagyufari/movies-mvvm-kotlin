package com.nacoda.moviesmvvm.data.source.remote

import com.nacoda.moviesmvvm.data.source.MoviesDataSource
import com.nacoda.moviesmvvm.util.helper.Network.API_KEY
import com.nacoda.moviesmvvm.util.helper.Network.LANGUAGE_ENGLISH
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

object MoviesRemoteDataSource : MoviesDataSource {
    override fun getDetail(callback: MoviesDataSource.GetDetailCallback, movieId: String) {
        mApiService.getDetail(
                API_KEY,
                LANGUAGE_ENGLISH,
                "1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ results ->
                    run {
                        if (results != null) {
                            callback.onDetailLoaded(results)
                        } else {
                            callback.onDataNotAvailable()
                        }
                    }
                }, { error ->
                    callback.onError(error.message)
                })
    }

    private val mApiService = MoviesService.create()
    private lateinit var mMovieId: String


    override fun getPopular(callback: MoviesDataSource.GetMoviesCallback) {
        mApiService.getPopular(
                API_KEY,
                LANGUAGE_ENGLISH,
                "1")
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

    override fun getNowPlaying(callback: MoviesDataSource.GetMoviesCallback) {
        mApiService.getNowPlaying(
                API_KEY,
                LANGUAGE_ENGLISH,
                "1")
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

    override fun getTopRated(callback: MoviesDataSource.GetMoviesCallback) {
        mApiService.getTopRated(
                API_KEY,
                LANGUAGE_ENGLISH,
                "1")
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

    override fun getSearch(callback: MoviesDataSource.GetMoviesCallback, query: String) {
        mApiService.getSearch(
                API_KEY,
                LANGUAGE_ENGLISH,
                query)
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


    override fun saveMovieId(movieId: String) {
        mMovieId = movieId
    }

    override fun getMovieId(): String {
        return mMovieId
    }


}
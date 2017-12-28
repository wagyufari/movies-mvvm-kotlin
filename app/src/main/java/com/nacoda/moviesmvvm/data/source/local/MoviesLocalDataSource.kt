package com.nacoda.moviesmvvm.data.source.local

import android.content.SharedPreferences
import android.support.annotation.VisibleForTesting
import com.nacoda.moviesmvvm.data.source.MoviesDataSource
import com.nacoda.moviesmvvm.util.helper.Preference

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class MoviesLocalDataSource private constructor(private val preferences: SharedPreferences) : MoviesDataSource {
    override fun getCasts(callback: MoviesDataSource.GetCastsCallback, movieId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDetail(callback: MoviesDataSource.GetDetailCallback, movieId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSearch(callback: MoviesDataSource.GetMoviesCallback, query: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNowPlaying(callback: MoviesDataSource.GetMoviesCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTopRated(callback: MoviesDataSource.GetMoviesCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveMovieId(movieId: String) {
        preferences.edit().putString(Preference.KEY, movieId)
    }

    override fun getMovieId(): String = preferences.getString(Preference.KEY, "")

    override fun getPopular(callback: MoviesDataSource.GetMoviesCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        private var INSTANCE: MoviesLocalDataSource? = null

        @JvmStatic
        fun getInstance(preferences: SharedPreferences): MoviesLocalDataSource {
            if (INSTANCE == null) {
                synchronized(MoviesLocalDataSource::javaClass) {
                    INSTANCE = MoviesLocalDataSource(preferences)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }
}
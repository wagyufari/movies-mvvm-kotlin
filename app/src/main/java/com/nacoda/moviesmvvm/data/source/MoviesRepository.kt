package com.nacoda.moviesmvvm.data.source

import com.nacoda.moviesmvvm.data.model.Detail
import com.nacoda.moviesmvvm.data.model.Movie


/**
 * Created by irfanirawansukirman on 04/12/17.
 */
open class MoviesRepository(val remoteDataSource: MoviesDataSource, val localDataSource: MoviesDataSource) : MoviesDataSource {
    override fun getDetail(callback: MoviesDataSource.GetDetailCallback, movieId: String) {
        remoteDataSource.getDetail(object : MoviesDataSource.GetDetailCallback {
            override fun onDetailLoaded(detail: Detail?) {
                callback.onDetailLoaded(detail)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(errorMessage: String?) {
                callback.onError(errorMessage)
            }

        }, movieId)
    }

    override fun getSearch(callback: MoviesDataSource.GetMoviesCallback, query: String) {
        remoteDataSource.getSearch(object : MoviesDataSource.GetMoviesCallback {
            override fun onMoviesLoaded(movies: List<Movie>?) {
                callback.onMoviesLoaded(movies)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(errorMessage: String?) {
                callback.onError(errorMessage)
            }
        }, query)
    }

    override fun getPopular(callback: MoviesDataSource.GetMoviesCallback) {
        remoteDataSource.getPopular(object : MoviesDataSource.GetMoviesCallback {
            override fun onMoviesLoaded(movies: List<Movie>?) {
                callback.onMoviesLoaded(movies)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(errorMessage: String?) {
                callback.onError(errorMessage)
            }
        })
    }

    override fun getNowPlaying(callback: MoviesDataSource.GetMoviesCallback) {
        remoteDataSource.getNowPlaying(object : MoviesDataSource.GetMoviesCallback {
            override fun onMoviesLoaded(movies: List<Movie>?) {
                callback.onMoviesLoaded(movies)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(errorMessage: String?) {
                callback.onError(errorMessage)
            }
        })
    }

    override fun getTopRated(callback: MoviesDataSource.GetMoviesCallback) {
        remoteDataSource.getTopRated(object : MoviesDataSource.GetMoviesCallback {
            override fun onMoviesLoaded(movies: List<Movie>?) {
                callback.onMoviesLoaded(movies)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(errorMessage: String?) {
                callback.onError(errorMessage)
            }
        })
    }

    override fun saveMovieId(movieId: String) {
        remoteDataSource.saveMovieId(movieId)
        localDataSource.saveMovieId(movieId)
    }

    override fun getMovieId(): String = localDataSource.getMovieId()

    companion object {

        private var INSTANCE: MoviesRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.

         * @param mJasaRaharjaRemoteDataSourcethe backend data source
         * *
         * @return the [MoviesRepository] instance
         */
        @JvmStatic
        fun getInstance(mMoviesRemoteDataSource: MoviesDataSource, mMoviesLocalDataSource: MoviesDataSource) =
                INSTANCE ?: synchronized(MoviesRepository::class.java) {
                    INSTANCE ?: MoviesRepository(mMoviesRemoteDataSource, mMoviesLocalDataSource)
                            .also { INSTANCE = it }
                }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
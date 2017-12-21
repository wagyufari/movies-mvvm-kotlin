package com.nacoda.moviesmvvm.data.source

import com.nacoda.moviesmvvm.data.model.Movie


/**
 * Created by irfanirawansukirman on 04/12/17.
 */
interface MoviesDataSource {

    /**
     * This sample function for save movie id to preference
     * @param movieId
     */
    fun saveMovieId(movieId: String)

    /**
     * This sample function for getting movie id from preference
     */
    fun getMovieId(): String

    /**
     * Get all movie list
     * @param callback
     */
    fun getMovies(callback: GetMoviesCallback)

    interface GetMoviesCallback {

        fun onMoviesLoaded(movies: List<Movie>?)

        fun onDataNotAvailable()

        fun onError(errorMessage: String?)
    }
}
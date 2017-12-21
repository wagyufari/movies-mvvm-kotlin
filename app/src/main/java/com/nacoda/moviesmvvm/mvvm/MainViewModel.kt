package com.nacoda.moviesmvvm.mvvm

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableList
import android.view.View
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.data.source.MoviesDataSource
import com.nacoda.moviesmvvm.data.source.MoviesRepository
import id.gits.jasaraharja.util.SingleLiveEvent
import java.util.*

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class MainViewModel(context: Application, private val mMoviesRepository: MoviesRepository) : AndroidViewModel(context) {

    val movieList: ObservableList<Movie> = ObservableArrayList()
    internal val mOpenMovieDetail = SingleLiveEvent<Movie>()
    val genres = ObservableField<String>()

    /**
     * Call this function for first init
     */
    fun start() {
        genres.set("majma")
        getMovies()
    }

    /**
     * Get movie list from API
     */
    private fun getMovies() {
        mMoviesRepository.getMovies(object : MoviesDataSource.GetMoviesCallback {
            override fun onMoviesLoaded(movies: List<Movie>?) {
                with(movieList) {
                    clear()
                    addAll(movies!!)
                }
            }

            override fun onDataNotAvailable() {
            }

            override fun onError(errorMessage: String?) {
                if (errorMessage != null) {
                }
            }

        })
    }

    fun getGenres(data: Array<String>): String {
        return Arrays.toString(data)
                .replace("28", "Action")
                .replace("12", "Adventure")
                .replace("16", "Animation")
                .replace("35", "Comedy")
                .replace("80", "Crime")
                .replace("99", "Documentary")
                .replace("18", "Drama")
                .replace("14", "Fantasy")
                .replace("27", "Horror")
                .replace("10402", "Music")
                .replace("9648", "Mystery")
                .replace("10749", "Romance")
                .replace("878", "Science Fiction")
                .replace("10770", "TV Movie")
                .replace("10752", "War")
                .replace("37", "Western")
                .replace("10751", "Family")
                .replace("53", "Thriller")
                .replace("[", "")
                .replace("]", "")
    }
}

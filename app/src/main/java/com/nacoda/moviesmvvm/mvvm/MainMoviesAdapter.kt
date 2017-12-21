package com.nacoda.moviesmvvm.mvvm

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nacoda.moviesmvvm.R
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.databinding.MainMoviesItemBinding
import com.nacoda.moviesmvvm.util.helper.Network.IMAGE_URL
import com.nacoda.moviesmvvm.util.helper.getGenres
import java.util.*

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class MainMoviesAdapter(private var mMovies: List<Movie>, private var mMainViewModel: MainViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val mMainItemBinding: MainMoviesItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context),
                R.layout.main_movies_item, parent, false)

        return MainItemHolder(mMainItemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val mMovieItem = mMovies[position]

        val mUserActionListener = object : MainItemUserActionListener {
            override fun onMovieClicked(movie: Movie) {
                mMainViewModel.mOpenMovieDetail.value = movie
            }
        }
        (holder as MainItemHolder).bindItem(mMovieItem, mUserActionListener)
    }

    override fun getItemCount(): Int {
        return mMovies.size
    }

    fun replaceData(mMovies: List<Movie>) {
        setList(mMovies)
    }

    fun setList(mMovies: List<Movie>) {
        this.mMovies = mMovies
        notifyDataSetChanged()
    }

    class MainItemHolder(itemView: MainMoviesItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val mMainItemBinding: MainMoviesItemBinding = itemView

        fun bindItem(movie: Movie, userActionListener: MainItemUserActionListener) {
            mMainItemBinding.item = movie
            mMainItemBinding.userActionListener = userActionListener
            mMainItemBinding.genres = getGenres(movie.genre_ids)
            mMainItemBinding.posterPath = (IMAGE_URL + movie.poster_path)
            mMainItemBinding.year = movie.release_date!!.substring(0,4)
            mMainItemBinding.executePendingBindings()
        }
    }


}
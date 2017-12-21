package com.nacoda.moviesmvvm.mvvm

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.nacoda.moviesmvvm.R
import com.nacoda.moviesmvvm.base.BaseActivity
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.util.obtainViewModel
import com.nacoda.moviesmvvm.util.replaceFragmentInActivity

class MainMoviesActivity : BaseActivity(), MainItemUserActionListener {

    private lateinit var mToolbar: Toolbar

    private lateinit var mViewModel: MainViewModel

    override fun onMovieClicked(movie: Movie) {
        Toast.makeText(mActiviy, movie.original_title, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_movies_activity)
        setupFragment()

        mViewModel = obtainViewModel().apply {

            mOpenMovieDetail.observe(this@MainMoviesActivity, Observer { movie ->
                onMovieClicked(movie!!)
            })

        }
    }

    /**
     * Do setup fragment main view
     */
    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.frame_main_content)
        MainFragment.newInstance().let {
            replaceFragmentInActivity(it, R.id.frame_main_content)
        }
    }

    fun obtainViewModel(): MainViewModel = obtainViewModel(MainViewModel::class.java)
}

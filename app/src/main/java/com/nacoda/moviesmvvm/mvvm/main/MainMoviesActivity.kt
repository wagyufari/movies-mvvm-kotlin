package com.nacoda.moviesmvvm.mvvm.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import com.nacoda.moviesmvvm.R
import com.nacoda.moviesmvvm.base.BaseActivity
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.PopularFragment
import com.nacoda.moviesmvvm.mvvm.main.movies.top.TopFragment
import com.nacoda.moviesmvvm.mvvm.main.search.SearchFragment
import com.nacoda.moviesmvvm.util.replaceFragmentInActivity
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.view.KeyEvent.KEYCODE_BACK


class MainMoviesActivity : BaseActivity(), MainItemUserActionListener {

    private lateinit var mToolbar: Toolbar

    override fun onMovieClicked(movie: Movie) {
        Toast.makeText(mActiviy, movie.original_title, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_movies_activity)
        setupFragment()

    }

    fun popFragment(view: View) {
        this.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KEYCODE_BACK))
        this.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KEYCODE_BACK))
        hideInputMethod()
    }

    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.movies_frame_popular)
        PopularFragment.newInstance().let {
            replaceFragmentInActivity(it, R.id.movies_frame_popular)
        }

        supportFragmentManager.findFragmentById(R.id.movies_frame_top)
        TopFragment.newInstance().let {
            replaceFragmentInActivity(it, R.id.movies_frame_top)
        }
    }

    fun hideInputMethod() {
        // Check if no view has focus:
        val view = currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
        }
    }

    fun showInputMethod() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    fun onSearchViewClicked(view: View) {
        addFragmentOnTop(SearchFragment.newInstance().apply {}, R.id.search_frame)
    }

    fun addFragmentOnTop(fragment: Fragment, layout: Int) {
        supportFragmentManager
                .beginTransaction()
                .replace(layout, fragment)
                .addToBackStack("something")
                .commit()
    }
}

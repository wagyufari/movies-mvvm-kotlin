package com.nacoda.moviesmvvm.mvvm.detail

import android.content.Context
import android.content.Intent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.View
import com.nacoda.moviesmvvm.R
import com.nacoda.moviesmvvm.base.BaseActivity
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.databinding.DetailHeaderFragmentBinding
import com.nacoda.moviesmvvm.mvvm.detail.header.DetailHeaderFragment
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.PopularFragment
import com.nacoda.moviesmvvm.mvvm.main.movies.top.TopFragment
import com.nacoda.moviesmvvm.mvvm.main.search.SearchFragment
import com.nacoda.moviesmvvm.util.replaceFragmentInActivity

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        setupFragment()

    }

    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.detail_header_frame)
        DetailHeaderFragment.newInstance(intent.getSerializableExtra(getString(R.string.detail_intent)) as Movie).let {
            replaceFragmentInActivity(it, R.id.detail_header_frame)
        }
    }
}

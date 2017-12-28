package com.nacoda.moviesmvvm.mvvm.detail

import android.os.Bundle
import com.nacoda.moviesmvvm.R
import com.nacoda.moviesmvvm.base.BaseActivity
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.util.replaceFragmentInActivity

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        setupFragment()

    }

    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.detail_header_frame)
        DetailFragment.newInstance(intent.getSerializableExtra(getString(R.string.detail_intent)) as Movie).let {
            replaceFragmentInActivity(it, R.id.detail_header_frame)
        }
    }
}

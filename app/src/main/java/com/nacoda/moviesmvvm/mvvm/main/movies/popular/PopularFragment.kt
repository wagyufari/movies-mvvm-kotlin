package com.nacoda.moviesmvvm.mvvm.main.movies.popular

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nacoda.moviesmvvm.base.BaseFragment
import com.nacoda.moviesmvvm.databinding.PopularFragmentBinding
import com.nacoda.moviesmvvm.util.obtainViewModel
import kotlinx.android.synthetic.main.popular_fragment.*

class PopularFragment : BaseFragment() {

    private lateinit var mViewDataBinding: PopularFragmentBinding
    private lateinit var mAdapter: PopularAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = PopularFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = obtainViewModel()
        }

        return mViewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewDataBinding.mViewModel?.start()
        setupMovies()
    }

    override fun onResume() {
        super.onResume()

        showProgressDialog(true)

        showProgressDialog(false)
    }

    private fun obtainViewModel(): PopularViewModel = obtainViewModel(PopularViewModel::class.java)

    /**
     * Do setup movie list to recyclerview after getting data from API
     */
    private fun setupMovies() {
        val mViewModel = mViewDataBinding.mViewModel

        if (mViewModel != null) {

            val layoutManager = LinearLayoutManager(activity)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL

            mAdapter = PopularAdapter(mViewModel.movieList, mViewModel, context)

            with(recyclerview_main) {
                adapter = mAdapter
                setLayoutManager(layoutManager)
            }
        }
    }

    companion object {

        fun newInstance() = PopularFragment().apply {

        }
    }
}
package com.nacoda.moviesmvvm.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nacoda.moviesmvvm.base.BaseFragment
import com.nacoda.moviesmvvm.databinding.MainFragmentBinding

/**
 * Created by irfanirawansukirman on 04/12/17.
 */
class MainFragment : BaseFragment() {

    private lateinit var mViewDataBinding: MainFragmentBinding

    private lateinit var mMoviesAdapter: MainMoviesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = MainFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = (activity as MainMoviesActivity).obtainViewModel()
        }

        return mViewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupMovies()
    }

    override fun onResume() {
        super.onResume()

        showProgressDialog(true)

        mViewDataBinding.mViewModel?.start()

        showProgressDialog(false)
    }

    /**
     * Do setup movie list to recyclerview after getting data from API
     */
    private fun setupMovies() {
        val mViewModel = mViewDataBinding.mViewModel

        if (mViewModel != null) {
            mMoviesAdapter = MainMoviesAdapter(mViewModel.movieList, mViewModel)
            mViewDataBinding.recyclerviewMain.adapter = mMoviesAdapter
        }
    }

    companion object {

        fun newInstance() = MainFragment().apply {

        }
    }
}
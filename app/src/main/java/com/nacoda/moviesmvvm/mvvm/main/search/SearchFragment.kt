package com.nacoda.moviesmvvm.mvvm.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nacoda.moviesmvvm.base.BaseFragment
import com.nacoda.moviesmvvm.databinding.SearchFragmentBinding
import com.nacoda.moviesmvvm.util.obtainViewModel
import kotlinx.android.synthetic.main.search_fragment.*
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.nacoda.moviesmvvm.mvvm.main.MainMoviesActivity


class SearchFragment : BaseFragment() {

    private lateinit var mViewDataBinding: SearchFragmentBinding
    private lateinit var mAdapter: SearchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = SearchFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = obtainViewModel()
        }

        return mViewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var mViewModel = mViewDataBinding.mViewModel
        (activity as MainMoviesActivity).showInputMethod()

        mViewModel!!.progressVisibility.set(View.GONE)
        mViewModel!!.errorTextVisibility.set(View.GONE)

        search.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                (activity as MainMoviesActivity).hideInputMethod()

                mViewModel.progressVisibility.set(View.VISIBLE)
                mViewModel.errorTextVisibility.set(View.GONE)

                mViewDataBinding.mViewModel?.start(search.text.toString(), recyclerViewSearch)
                return@OnEditorActionListener true
            }
            false
        })
    }

    override fun onResume() {
        super.onResume()

        showProgressDialog(true)

        showProgressDialog(false)
    }


    companion object {

        fun newInstance() = SearchFragment().apply {

        }
    }

    private fun obtainViewModel(): SearchViewModel = obtainViewModel(SearchViewModel::class.java)
}
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
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.nacoda.moviesmvvm.mvvm.main.MainMoviesActivity
import com.nacoda.moviesmvvm.util.helper.hideProgress
import com.nacoda.moviesmvvm.util.helper.onSearchStarted


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

        YoYo.with(Techniques.SlideInUp)
                .duration(300)
                .playOn(search)

        val mViewModel = mViewDataBinding.mViewModel
        (activity as MainMoviesActivity).showInputMethod()

        hideProgress(mViewModel!!.progressVisibility, mViewModel.recyclerVisibility, mViewModel.errorTextVisibility)

        search.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                (activity as MainMoviesActivity).hideInputMethod()

                onSearchStarted(mViewModel.progressVisibility, mViewModel.errorTextVisibility)

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
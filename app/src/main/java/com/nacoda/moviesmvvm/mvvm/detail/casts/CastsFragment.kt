package com.nacoda.moviesmvvm.mvvm.detail.casts

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nacoda.moviesmvvm.base.BaseFragment
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.databinding.CastsFragmentBinding
import com.nacoda.moviesmvvm.databinding.InfoFragmentBinding
import com.nacoda.moviesmvvm.util.obtainViewModel
import kotlinx.android.synthetic.main.casts_fragment.*

@SuppressLint("ValidFragment")
class CastsFragment @SuppressLint("ValidFragment") constructor
(var mMovie: Movie) : BaseFragment() {



    private lateinit var mViewDataBinding: CastsFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = CastsFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = obtainViewModel()
        }

        return mViewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewDataBinding.mViewModel?.start(mMovie, recyclerViewCasts)
    }

    private fun obtainViewModel(): CastsViewModel = obtainViewModel(CastsViewModel::class.java)

    companion object {

        fun newInstance(mMovie: Movie) = CastsFragment(mMovie).apply {

        }
    }
}
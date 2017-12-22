package com.nacoda.moviesmvvm.mvvm.detail.header

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nacoda.moviesmvvm.base.BaseFragment
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.databinding.DetailHeaderFragmentBinding
import com.nacoda.moviesmvvm.databinding.PopularFragmentBinding
import com.nacoda.moviesmvvm.util.helper.Network
import com.nacoda.moviesmvvm.util.obtainViewModel
import kotlinx.android.synthetic.main.popular_fragment.*

@SuppressLint("ValidFragment")
class DetailHeaderFragment @SuppressLint("ValidFragment") constructor
(var mMovie: Movie) : BaseFragment() {

    private lateinit var mViewDataBinding: DetailHeaderFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = DetailHeaderFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = obtainViewModel()
        }

        return mViewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewDataBinding.mMovie = mMovie
        mViewDataBinding.backdropPath = (Network.IMAGE_URL + mMovie.backdrop_path)
    }

    override fun onResume() {
        super.onResume()
        showProgressDialog(true)
        mViewDataBinding.mViewModel?.start(mMovie)
        showProgressDialog(false)
    }

    private fun obtainViewModel(): DetailHeaderViewModel = obtainViewModel(DetailHeaderViewModel::class.java)

    companion object {

        fun newInstance(mMovie: Movie) = DetailHeaderFragment(mMovie).apply {

        }
    }
}
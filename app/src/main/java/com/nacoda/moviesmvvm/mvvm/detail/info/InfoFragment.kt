package com.nacoda.moviesmvvm.mvvm.detail.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nacoda.moviesmvvm.base.BaseFragment
import com.nacoda.moviesmvvm.databinding.InfoFragmentBinding
import com.nacoda.moviesmvvm.util.obtainViewModel

class InfoFragment : BaseFragment() {

    private lateinit var mViewDataBinding: InfoFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = InfoFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = obtainViewModel()
        }

        return mViewDataBinding.root
    }

    private fun obtainViewModel(): InfoViewModel = obtainViewModel(InfoViewModel::class.java)

    companion object {

        fun newInstance() = InfoFragment().apply {

        }
    }
}
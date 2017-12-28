package com.nacoda.moviesmvvm.mvvm.detail

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nacoda.moviesmvvm.R
import com.nacoda.moviesmvvm.base.BaseFragment
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.databinding.CastsFragmentBinding
import com.nacoda.moviesmvvm.databinding.DetailFragmentBinding
import com.nacoda.moviesmvvm.mvvm.detail.casts.CastsFragment
import com.nacoda.moviesmvvm.mvvm.detail.info.InfoFragment
import com.nacoda.moviesmvvm.util.helper.Network
import com.nacoda.moviesmvvm.util.helper.getGenres
import com.nacoda.moviesmvvm.util.obtainViewModel
import kotlinx.android.synthetic.main.detail_fragment.*
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat

@SuppressLint("ValidFragment")
class DetailFragment @SuppressLint("ValidFragment") constructor
(var mMovie: Movie) : BaseFragment() {

    private lateinit var mViewDataBinding: DetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = DetailFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = obtainViewModel()
        }

        return mViewDataBinding.root
    }

    @SuppressLint("SimpleDateFormat")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewDataBinding.mMovie = mMovie
        mViewDataBinding.backdropPath = Network.IMAGE_URL + mMovie.backdrop_path
        mViewDataBinding.posterPath = Network.IMAGE_URL + mMovie.poster_path
        mViewDataBinding.genres = getGenres(mMovie.genre_ids)
        val date = SimpleDateFormat("mm dd, yyyy").format(SimpleDateFormat("yyyy-mm-dd").parse(mMovie.release_date))
        mViewDataBinding.releaseYear = DateFormatSymbols().months[date.substring(0, 2).toInt() - 1] + (" ") + date.substring(3, date.length)
        tab_strip.typeface = Typeface.createFromAsset(activity.assets, "fonts/comfortaa_bold.ttf")

        val tabAdapter = TabSliderAdapter(fragmentManager)
        tabAdapter.addFragment(InfoFragment.newInstance(), "")
        tabAdapter.addFragment(CastsFragment.newInstance(mMovie), "")
        tabAdapter.addFragment(InfoFragment.newInstance(), "")
        view_pager.adapter = tabAdapter
        tab_strip.setViewPager(view_pager, 0)
        tab_layout.setTabTextColors(resources.getColor(R.color.greyIndicator), resources.getColor(R.color.colorAccent));
        tab_layout.setupWithViewPager(view_pager)


    }

    private fun obtainViewModel(): DetailViewModel = obtainViewModel(DetailViewModel::class.java)

    companion object {

        fun newInstance(mMovie: Movie) = DetailFragment(mMovie).apply {

        }
    }
}
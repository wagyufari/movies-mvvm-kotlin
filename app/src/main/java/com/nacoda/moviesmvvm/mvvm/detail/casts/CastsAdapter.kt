package com.nacoda.moviesmvvm.mvvm.detail.casts

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nacoda.moviesmvvm.R
import com.nacoda.moviesmvvm.data.model.Casts
import com.nacoda.moviesmvvm.databinding.CastsMoviesItemBinding
import com.nacoda.moviesmvvm.util.helper.Network

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class CastsAdapter(private var mCasts: Casts, private var mCastsViewModel: CastsViewModel, var mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val mCastsItemBinding: CastsMoviesItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context),
                R.layout.casts_movies_item, parent, false)

        return CastsItemHolder(mCastsItemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val mCastsItem = mCasts.cast!![position]
        (holder as CastsItemHolder).bindItem(mCastsItem)
    }

    override fun getItemCount(): Int {
        return mCasts.cast!!.size
    }

    fun replaceData(mCasts: Casts) {
        setList(mCasts)
    }

    fun setList(mCasts: Casts) {
        this.mCasts = mCasts
        notifyDataSetChanged()
    }

    class CastsItemHolder(itemView: CastsMoviesItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val mCastsItemBinding: CastsMoviesItemBinding = itemView

        fun bindItem(casts: Casts.Cast) {

            mCastsItemBinding.casts = casts
            mCastsItemBinding.profilePath = Network.IMAGE_URL + casts.profile_path
            mCastsItemBinding.character = "as " + casts.character
            mCastsItemBinding.executePendingBindings()

        }
    }


}
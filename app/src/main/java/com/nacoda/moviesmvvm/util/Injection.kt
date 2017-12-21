package com.nacoda.moviesmvvm.util

import android.content.Context
import android.preference.PreferenceManager
import com.nacoda.moviesmvvm.data.source.MoviesRepository
import com.nacoda.moviesmvvm.data.source.remote.MoviesRemoteDataSource
import com.nacoda.moviesmvvm.data.source.local.MoviesLocalDataSource

/**
 * Created by irfanirawansukirman on 04/12/17.
 */
object Injection {

    fun provideMoviesRepository(mContext: Context) =
            MoviesRepository.getInstance(MoviesRemoteDataSource,
                    MoviesLocalDataSource.getInstance(PreferenceManager.getDefaultSharedPreferences(mContext)))
}
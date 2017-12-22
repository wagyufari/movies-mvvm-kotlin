package com.nacoda.moviesmvvm.data.model

import android.support.v7.app.AppCompatActivity
import java.io.Serializable

/**
 * Created by Mayburger on 12/22/17.
 */

data class Detail(
        var adult: Boolean = false,
        var backdrop_path: String? = null,
        var genres: Array<String>,
        var homepage: String?,
        var id: String?,
        var imdb_id: String?,
        var original_language: String?,
        var original_title: String?,
        var overview: String?,
        var popularity: String?,
        var poster_path: String?,
        var release_date: String?,
        var runtime: String?,
        var title: String?,
        var vote_average: Int,
        var vote_count: Int
)
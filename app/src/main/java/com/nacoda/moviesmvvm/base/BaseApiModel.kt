package com.nacoda.moviesmvvm.base

import com.nacoda.moviesmvvm.data.model.Movie

/**
 * Created by Mayburger on 12/22/17.
 */

class BaseApiModel<T> {

    var page: Int = 0
    var total_results: String? = null
    var total_pages: String? = null
    var results: List<Movie>? = null

}

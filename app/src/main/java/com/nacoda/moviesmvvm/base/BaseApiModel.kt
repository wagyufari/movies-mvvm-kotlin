package id.gits.jasaraharja.base

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class BaseApiModel<T>(
        var page: Int,
        var total_results: Int,
        var total_pages: Int,
        var results: T? = null

    //Todo code above just for testing. Change it with real base response from API
)

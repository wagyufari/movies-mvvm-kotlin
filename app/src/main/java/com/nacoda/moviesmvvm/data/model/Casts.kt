package com.nacoda.moviesmvvm.data.model

/**
 * Created by Mayburger on 12/28/17.
 */


class Casts {
    var id:String? = null
    var cast: List<Cast>? = null

    data class Cast(
            var cast_id:String? = null,
            var character:String? = null,
            var credit_id:String? = null,
            var gender:String? = null,
            var id:String? = null,
            var name:String? = null,
            var order:String? = null,
            var profile_path:String? = null
    )

}
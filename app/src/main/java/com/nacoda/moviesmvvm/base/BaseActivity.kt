package com.nacoda.moviesmvvm.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Mayburger on 12/22/17.
 */

open class BaseActivity : AppCompatActivity() {

    internal lateinit var mActivity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        mActivity = this
    }
}

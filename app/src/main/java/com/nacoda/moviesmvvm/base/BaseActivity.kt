package com.nacoda.moviesmvvm.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by irfanirawansukirman on 04/12/17.
 */
open class BaseActivity : AppCompatActivity() {

    lateinit var mActiviy: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActiviy = this
    }
    //Todo attach base context calligraphy font in here
}
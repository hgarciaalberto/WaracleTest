package com.ahgitdevelopment.waracletest.ui

import android.os.Bundle
import com.ahgitdevelopment.waracletest.R
import com.ahgitdevelopment.waracletest.base.BaseActivity
import com.ahgitdevelopment.waracletest.ui.main.MainFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    MainFragment.newInstance()
                )
                .commitNow()
        }
    }
}

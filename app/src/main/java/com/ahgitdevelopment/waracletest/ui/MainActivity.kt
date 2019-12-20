package com.ahgitdevelopment.waracletest.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.ahgitdevelopment.waracletest.R
import com.ahgitdevelopment.waracletest.base.BaseActivity
import com.ahgitdevelopment.waracletest.common.TAG_MAIN_FRAGMENT
import com.ahgitdevelopment.waracletest.ui.main.MainFragment

class MainActivity : BaseActivity() {

    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(), TAG_MAIN_FRAGMENT)
                .commitNow()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.refresh -> {
                currentFragment = supportFragmentManager.findFragmentByTag(TAG_MAIN_FRAGMENT)
                (currentFragment as MainFragment).fetchCakeList()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}

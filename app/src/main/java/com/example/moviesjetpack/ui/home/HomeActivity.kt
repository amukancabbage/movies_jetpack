package com.example.moviesjetpack.ui.home

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesjetpack.R
import com.example.moviesjetpack.ui.movies.MoviesFragment

class HomeActivity : AppCompatActivity() {

    private val SELECTED_MENU = "selected_menu"
    var navView: BottomNavigationView? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var fragment: Fragment? = null


        if (item.itemId == R.id.action_home) {
            fragment = MoviesFragment.newInstance()
        }else{
            fragment = MoviesFragment.newInstance()
        }
//        else if (item.itemId == R.id.action_bookmark) {
//            fragment = BookmarkFragment.newInstance()
//        }

        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container, fragment)
                .commit()
        }

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if(savedInstanceState!=null)
            savedInstanceState.getInt(SELECTED_MENU)
        else
            navView.selectedItemId = R.id.action_home

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_MENU, navView!!.getSelectedItemId())
    }
}

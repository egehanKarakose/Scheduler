package com.egehankarakose.scheduler

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.core.content.ContextCompat.startActivity
import androidx.viewpager.widget.ViewPager
import com.egehankarakose.scheduler.monday.*
import com.egehankarakose.scheduler.utils.CustomListViewAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)




        var adapter = HomePagesAdapter(supportFragmentManager)
        var viewPager =findViewById<ViewPager>(R.id.homeViewPager)
        setPageAdapter(viewPager)

        var tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)



    }
    fun setPageAdapter(viewPager: ViewPager){
        var homePagesAdapter = HomePagesAdapter(supportFragmentManager)
        homePagesAdapter.addFragment(monday_fragment(),"Mon")
        homePagesAdapter.addFragment(tuesday_fragment(),"Tue")
        homePagesAdapter.addFragment(wednesday_fragment(),"Wed")
        homePagesAdapter.addFragment(thursday_fragment(),"Thu")
        homePagesAdapter.addFragment(friday_fragment(),"Frı")
        homePagesAdapter.addFragment(saturday_fragment(),"Sat")
        homePagesAdapter.addFragment(sunday_fragment(),"Sun")

        homeViewPager.adapter = homePagesAdapter
        homeViewPager.setCurrentItem(0)

    }

    fun addEvent(view : View){

        val intent = Intent(applicationContext,AddEventActivity::class.java)
        startActivity(intent)



    }


}

package com.egehankarakose.scheduler

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomePagesAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){

    private var myFragmentList:ArrayList<Fragment> = ArrayList()
    private var myFragmentTitleList:ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {

        return myFragmentList.get(position)
    }

    override fun getCount(): Int {
        return myFragmentList.size
    }

    // personal function
    fun addFragment(fragment: Fragment,title: String){
        myFragmentList.add(fragment)
        myFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return myFragmentTitleList.get(position)
    }
}
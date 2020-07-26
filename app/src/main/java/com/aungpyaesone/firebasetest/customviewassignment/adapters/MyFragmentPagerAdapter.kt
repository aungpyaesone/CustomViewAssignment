package com.aungpyaesone.firebasetest.customviewassignment.adapters

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.aungpyaesone.firebasetest.customviewassignment.fragments.ProjectTaskFragment


class MyFragmentPagerAdapter(val context: Context,val fm:FragmentManager) : FragmentPagerAdapter(fm) {

    var title = arrayListOf("Project","Profile","Contact")
    private val NUM_ITEM = 3

    override fun getItem(position: Int): Fragment {
    when(position){
        0 -> {
            return ProjectTaskFragment.newInstance("","")
        }
        1 -> {
            return ProjectTaskFragment.newInstance("","")
        }
        2 -> {
            return ProjectTaskFragment.newInstance("","")
        }
        else -> {
            return ProjectTaskFragment.newInstance("","")
        }
    }
    }

    override fun getCount(): Int {
        return NUM_ITEM
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }



}
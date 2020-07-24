package com.aungpyaesone.firebasetest.customviewassignment.adapters

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class MyFragmentPagerAdapter(val context: Context,fm: FragmentManager,
var myFrags: List<Fragment>,var cats  : List<String>) : FragmentPagerAdapter(fm) {

    private var myFragment: List<Fragment> = arrayListOf()

    companion object{
        private var pos = 0
        fun setPos(position : Int) {
            pos = position
        }
    }
    override fun getItem(position: Int): Fragment {
        myFragment = myFrags
       return myFragment.get(position)
    }

    override fun getCount(): Int {
        myFragment = myFrags
        return myFrags.count()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        setPos(position)
        return cats.get(position)
    }

    fun add(
        c: Class<Fragment?>,
        title: String?,
        b: Bundle?
    ) {
       myFragment.toMutableList().add(Fragment.instantiate(context,c.name,b))
        title?.let { cats.toMutableList().add(it) }
    }

    init {
        myFragment = myFrags
    }

}
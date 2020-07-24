package com.aungpyaesone.firebasetest.customviewassignment.utils

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.aungpyaesone.firebasetest.customviewassignment.activities.ProfileScreenActivity
import com.aungpyaesone.firebasetest.customviewassignment.adapters.MyFragmentPagerAdapter
import com.aungpyaesone.firebasetest.customviewassignment.fragments.ProjectTaskFragment

fun buildFragment(context: Context,categories:List<String>):List<Fragment>{
    val fragment = arrayListOf<Fragment>()
    for(i in 0 until categories.size){
        val b = Bundle()
        b.putInt("position",i)
        fragment.toMutableList().add(Fragment.instantiate(context,ProjectTaskFragment.javaClass.name,b))
    }
    return fragment
}
package com.aungpyaesone.firebasetest.customviewassignment.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.aungpyaesone.firebasetest.customviewassignment.R
import com.aungpyaesone.firebasetest.customviewassignment.adapters.MyFragmentPagerAdapter
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenterImpls.ProfileScreenPresenterImpl
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters.ProfileScreenPresenter
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.ProfileView
import com.aungpyaesone.firebasetest.customviewassignment.utils.buildFragment
import com.aungpyaesone.firebasetest.customviewassignment.views.view_pods.UserProfileViewPod
import kotlinx.android.synthetic.main.activity_profile_screen.*

class ProfileScreenActivity : BaseActivity(), ProfileView {

    private lateinit var mProfileViewPod: UserProfileViewPod
    private lateinit var mPresenter: ProfileScreenPresenter
    private lateinit var mViewPagerAdapter: MyFragmentPagerAdapter



    companion object{
        fun newIntent(context:Context): Intent {
            return  Intent(context,ProfileScreenActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)
        setUpPresenter()
        setUpViewPod()
        setUpViewPager()
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(ProfileScreenPresenterImpl::class.java)

    }
    private fun setUpViewPod(){
        mProfileViewPod = profileViewPod as UserProfileViewPod
        mProfileViewPod.setUpDelegate(mPresenter)
    }

    private fun setUpViewPager(){
//        val categories = arrayListOf<String>("1","2","3")
//        val fragment = buildFragment(this,categories = categories)
        mViewPagerAdapter = MyFragmentPagerAdapter(this,supportFragmentManager)
        viewPager.adapter = mViewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

    }


}
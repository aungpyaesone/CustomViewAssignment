package com.aungpyaesone.firebasetest.customviewassignment.mvp.presenterImpls

import android.util.Log
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters.AbastractBasePresenter
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters.ProfileScreenPresenter
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.MainView
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.ProfileView

class ProfileScreenPresenterImpl : ProfileScreenPresenter, AbastractBasePresenter<ProfileView>() {

    override fun onTapProfileImage() {
        Log.d("TAG"," tap image")
    }


}
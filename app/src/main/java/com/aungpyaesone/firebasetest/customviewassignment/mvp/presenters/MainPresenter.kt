package com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.aungpyaesone.firebasetest.customviewassignment.delegates.MainScreenDelegate
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.BaseView
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView>, MainScreenDelegate {

    fun onUiReady(lifecycleOwner: LifecycleOwner)
}
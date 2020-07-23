package com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters

import androidx.lifecycle.ViewModel
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.BaseView

abstract class AbastractBasePresenter<T:BaseView> : BasePresenter<T>,ViewModel(){

    var mView : T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}
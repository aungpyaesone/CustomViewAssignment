package com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters

import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.BaseView

interface BasePresenter<T:BaseView>{

    fun initPresenter(view : T)
}
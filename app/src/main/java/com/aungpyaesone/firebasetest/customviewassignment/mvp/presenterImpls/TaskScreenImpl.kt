package com.aungpyaesone.firebasetest.customviewassignment.mvp.presenterImpls

import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters.AbastractBasePresenter
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters.TaskScreenPresenter
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.TaskScreenView

class TaskScreenImpl : TaskScreenPresenter, AbastractBasePresenter<TaskScreenView>() {
    override fun navigateToProfileScreen() {
        mView?.navigateToProfileScreen()
    }
}
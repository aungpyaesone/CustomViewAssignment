package com.aungpyaesone.firebasetest.customviewassignment.mvp.presenterImpls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.aungpyaesone.firebasetest.customviewassignment.data.models.TaskModelImpl
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters.AbastractBasePresenter
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters.MainPresenter
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbastractBasePresenter<MainView>() {

    private val mTaskModel = TaskModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
       mTaskModel.getAllTask().observe(lifecycleOwner, Observer {
        mView?.displayTaskList(it)
       })
    }

    override fun navigateToProfileScreen() {
      mView?.navigateToProfileScreen()
    }

    override fun navigateToCreateTaskScreen() {
        mView?.navigateToCreateTaskScreen()
    }

    override fun onTapProfileImage() {
        mView?.navigateToProfileScreen()
    }
}
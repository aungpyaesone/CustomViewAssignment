package com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters

import com.aungpyaesone.firebasetest.customviewassignment.delegates.TaskScreenDelegate
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.TaskScreenView

interface TaskScreenPresenter : BasePresenter<TaskScreenView>,TaskScreenDelegate {
}
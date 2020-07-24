package com.aungpyaesone.firebasetest.customviewassignment.mvp.views

import com.aungpyaesone.firebasetest.customviewassignment.data.vos.TaskVO

interface MainView : BaseView {
    fun displayTaskList(taskList: List<TaskVO>)
    fun navigateToProfileScreen()
    fun navigateToCreateTaskScreen()
    
}
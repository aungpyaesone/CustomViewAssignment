package com.aungpyaesone.firebasetest.customviewassignment.data.models

import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.customviewassignment.data.vos.TaskVO

interface TaskModel {
    fun getAllTask() : LiveData<List<TaskVO>>
}
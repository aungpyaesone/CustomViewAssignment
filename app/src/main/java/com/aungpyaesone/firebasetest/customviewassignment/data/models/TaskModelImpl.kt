package com.aungpyaesone.firebasetest.customviewassignment.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aungpyaesone.firebasetest.customviewassignment.data.vos.TaskVO
import com.aungpyaesone.firebasetest.customviewassignment.data.dummy.getDummyTask

object TaskModelImpl : BaseModel(),TaskModel {

  //  var mTaskData = mutableListOf<TaskVO>()
    override fun getAllTask(): LiveData<List<TaskVO>> {
        var liveData = MutableLiveData<List<TaskVO>>()
        liveData.postValue(getDummyTask())
        return liveData
    }
}
package com.aungpyaesone.firebasetest.customviewassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpyaesone.firebasetest.customviewassignment.R
import com.aungpyaesone.firebasetest.customviewassignment.data.vos.TaskVO
import com.aungpyaesone.firebasetest.customviewassignment.delegates.TaskItemDelegate
import com.aungpyaesone.firebasetest.customviewassignment.views.viewholders.BaseViewHolder
import com.aungpyaesone.firebasetest.customviewassignment.views.viewholders.TaskListViewHolder

class TaskListAdapter (val mDelegate: TaskItemDelegate) : BaseAdapter<BaseViewHolder<TaskVO>, TaskVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<TaskVO> {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.task_item_view,parent,false)
        return TaskListViewHolder(view,mDelegate)
    }


}
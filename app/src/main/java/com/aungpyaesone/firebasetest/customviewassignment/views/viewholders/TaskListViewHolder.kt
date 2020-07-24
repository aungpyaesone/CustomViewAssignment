package com.aungpyaesone.firebasetest.customviewassignment.views.viewholders

import android.view.View
import com.aungpyaesone.firebasetest.customviewassignment.data.vos.TaskVO
import com.aungpyaesone.firebasetest.customviewassignment.delegates.TaskItemDelegate
import kotlinx.android.synthetic.main.task_item_view.view.*

class TaskListViewHolder(itemView: View,val mDelegate: TaskItemDelegate) : BaseViewHolder<TaskVO>(itemView) {

    override fun bindData(data: TaskVO) {
        mData = data
        itemView.tvInProgress.text = data.status
        itemView.tvContactPage.text = data.title
        itemView.tvType.text = data.type
        itemView.tvMessage.text = data.comment.toString()
        itemView.tvAttach.text = data.attach.toString()
        itemView.tvNumber.text = data.number

        itemView.ivProfile.setOnClickListener {
            mDelegate.onTapProfileImage()
        }
    }
}
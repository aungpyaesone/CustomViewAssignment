package com.aungpyaesone.firebasetest.customviewassignment.adapters

import androidx.recyclerview.widget.RecyclerView
import com.aungpyaesone.firebasetest.customviewassignment.views.viewholders.BaseViewHolder

abstract class BaseAdapter<T:BaseViewHolder<W>,W> : RecyclerView.Adapter<T>(){
    var mData : MutableList<W> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    fun setData(data: MutableList<W>){
        mData = data
        notifyDataSetChanged()
    }

    fun appendData(data: List<W>){
        mData.addAll(data)
        notifyDataSetChanged()
    }
}
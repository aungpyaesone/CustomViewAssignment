package com.aungpyaesone.firebasetest.customviewassignment.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpyaesone.firebasetest.customviewassignment.R
import com.aungpyaesone.firebasetest.customviewassignment.adapters.TaskListAdapter
import com.aungpyaesone.firebasetest.customviewassignment.data.vos.TaskVO
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters.MainPresenter
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenterImpls.MainPresenterImpl
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.MainView
import com.aungpyaesone.firebasetest.customviewassignment.utils.ItemDecorator
import com.aungpyaesone.firebasetest.customviewassignment.views.components.CircularProgressBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainView {

    private lateinit var mTaskAdapter : TaskListAdapter
    private lateinit var mPresenter : MainPresenter
    private lateinit var mCircularProgress : CircularProgressBar

    companion object{
        fun newIntent(context:Context): Intent{
            return  Intent(context,MainActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        setUpRecycler()
        setUpListener()
        setUpProgress()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpProgress(){
        mCircularProgress = circularProgress as CircularProgressBar
        mCircularProgress.setProgress(80)
        mCircularProgress.setProgressColor(Color.RED)
    }
    private fun setUpRecycler(){
        mTaskAdapter = TaskListAdapter(mPresenter)
        val linearLayoutManager =LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvTask.layoutManager = linearLayoutManager
        rvTask.addItemDecoration(ItemDecorator(-40))
        rvTask.adapter = mTaskAdapter
    }

    override fun displayTaskList(taskList: List<TaskVO>) {
        mTaskAdapter.setData(taskList.toMutableList())
    }

    override fun navigateToProfileScreen() {
        startActivity(ProfileScreenActivity.newIntent(this))
    }

    private fun setUpListener(){
        ivProfileOne.setOnClickListener {
            mPresenter.navigateToProfileScreen()
        }

        ivProfileTwo.setOnClickListener {
            mPresenter.navigateToProfileScreen()
        }

        ivProfileThree.setOnClickListener {
            mPresenter.navigateToProfileScreen()
        }

        ivProfileFour.setOnClickListener {
            mPresenter.navigateToCreateTaskScreen()
        }
    }

    override fun navigateToCreateTaskScreen() {
        startActivity(TaskScreenActivity.newIntent(this))
    }

}
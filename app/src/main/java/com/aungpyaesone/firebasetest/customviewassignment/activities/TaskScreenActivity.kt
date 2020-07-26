package com.aungpyaesone.firebasetest.customviewassignment.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.aungpyaesone.firebasetest.customviewassignment.R
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenterImpls.TaskScreenImpl
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters.TaskScreenPresenter
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.TaskScreenView
import kotlinx.android.synthetic.main.activity_task_screen.*

class TaskScreenActivity : BaseActivity(),TaskScreenView {
    private lateinit var mPresenter: TaskScreenPresenter


    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,TaskScreenActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_screen)
        setUpPresenter()
        setUpListener()
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(TaskScreenImpl::class.java)
        mPresenter.initPresenter(this)

    }
    private fun setUpListener(){
        roundedCornerImageView.setOnClickListener {
            mPresenter.navigateToProfileScreen()
        }
    }

    override fun navigateToProfileScreen() {
        startActivity(ProfileScreenActivity.newIntent(this))
    }
}
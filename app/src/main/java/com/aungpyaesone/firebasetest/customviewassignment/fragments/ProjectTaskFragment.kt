package com.aungpyaesone.firebasetest.customviewassignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpyaesone.firebasetest.customviewassignment.R
import com.aungpyaesone.firebasetest.customviewassignment.activities.ProfileScreenActivity
import com.aungpyaesone.firebasetest.customviewassignment.activities.TaskScreenActivity
import com.aungpyaesone.firebasetest.customviewassignment.adapters.TaskListAdapter
import com.aungpyaesone.firebasetest.customviewassignment.data.vos.TaskVO
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenterImpls.MainPresenterImpl
import com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters.MainPresenter
import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.MainView
import kotlinx.android.synthetic.main.fragment_project_task.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProjectTaskFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProjectTaskFragment : Fragment(),MainView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mAdapter: TaskListAdapter
    private lateinit var mPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setupRecycler()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setupRecycler(){
        mAdapter = TaskListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        rvProjectFragment.layoutManager = linearLayoutManager
        rvProjectFragment.adapter = mAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProjectTaskFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProjectTaskFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun displayTaskList(taskList: List<TaskVO>) {
        mAdapter.setData(taskList.toMutableList())
    }

    override fun navigateToProfileScreen() {
        startActivity(activity?.let { ProfileScreenActivity.newIntent(it) })
    }

    override fun navigateToCreateTaskScreen() {
        startActivity(activity?.let { TaskScreenActivity.newIntent(it) })
    }
}
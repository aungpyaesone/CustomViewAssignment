package com.aungpyaesone.firebasetest.customviewassignment.views.view_pods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.profile_view_pod.view.*

class UserProfileViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate : Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    private fun setUpListener(){
        ivProfile.setOnClickListener {
            mDelegate?.onTapProfileImage()
        }
    }

    fun setUpDelegate(delegate: Delegate?){
        mDelegate = delegate
    }

    interface Delegate {
        fun onTapProfileImage()
    }
}
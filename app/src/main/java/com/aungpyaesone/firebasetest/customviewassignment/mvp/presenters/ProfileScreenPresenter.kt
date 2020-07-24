package com.aungpyaesone.firebasetest.customviewassignment.mvp.presenters

import com.aungpyaesone.firebasetest.customviewassignment.mvp.views.ProfileView
import com.aungpyaesone.firebasetest.customviewassignment.views.view_pods.UserProfileViewPod

interface ProfileScreenPresenter : BasePresenter<ProfileView>, UserProfileViewPod.Delegate {
}
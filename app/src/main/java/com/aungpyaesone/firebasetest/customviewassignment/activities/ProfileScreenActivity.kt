package com.aungpyaesone.firebasetest.customviewassignment.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aungpyaesone.firebasetest.customviewassignment.R

class ProfileScreenActivity : BaseActivity() {

    companion object{
        fun newIntent(context:Context): Intent {
            return  Intent(context,ProfileScreenActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)
    }
}
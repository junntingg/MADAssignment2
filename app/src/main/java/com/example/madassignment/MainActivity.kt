package com.example.madassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var mHandler: Handler
    lateinit var mRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun startMainActivity() {
            mRunnable = Runnable {
                startActivity(Intent(this, homepage::class.java))
                finish()
            }

            mHandler = Handler()

            mHandler.postDelayed(mRunnable, 5000)
        }
        startMainActivity()
    }
    override fun onStop() {
        super.onStop()
        mHandler.removeCallbacks(mRunnable)
    }
}
package com.example.madassignment.Staff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.madassignment.R
import com.example.madassignment.data.UserDao
import com.example.madassignment.data.UserDatabase
import com.example.madassignment.data.UserViewModel
import kotlinx.android.synthetic.main.activity_main_login.*

private lateinit var mUserViewModel: UserViewModel

class MainLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)
    }

    fun loginLogin(view: View){

        val userDao = UserDatabase.getDatabase(applicationContext)?.userDao()

        val email = staffIDLogin.text.toString()
        val password = passwordLogin.text.toString()

        if(email == null || password == null){

            Toast.makeText(this, "Please fill up all fields.", Toast.LENGTH_LONG).show()

        }else{
            mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            val user = mUserViewModel.staffLogin(email, password)

        }

    }

}
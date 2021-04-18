package com.example.madassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main_login.*

class MainLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)
    }

    fun loginLogin(view: View){

        if(staffIDLogin.text.toString() == passwordLogin.text.toString()){



        }else{

        }

    }

}
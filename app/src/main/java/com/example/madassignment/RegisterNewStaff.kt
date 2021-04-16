package com.example.madassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.madassignment.data.User
import com.example.madassignment.data.UserViewModel
import kotlinx.android.synthetic.main.activity_register_new_staff.*

class RegisterNewStaff : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_new_staff)
    }

    fun onCLickCreate(view: View){

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        insertDataToDatabase()
    }

    private fun insertDataToDatabase() {
        val name = nameRegisterNewStaff.text.toString()
        val icNo = icNoRegisterNewStaff.text.toString()
        val password = passRegisterNewStaff.text.toString()
        val address = addressRegisterNewStaff.text.toString()
        val email = emailRegisterNewStaff.text.toString()
        val phoneNo = phoneNoRegisterNewStaff.text.toString()

        if(inputCheck(name, icNo, password, address, email, phoneNo)){
            //Create User Object
            val user = User(0, name, icNo, password, address, email, phoneNo)
            //Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(this, "Successfully added", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Please fill up all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, icNo: String, password: String, address: String, email: String, phoneNo: String): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(icNo) && TextUtils.isEmpty(password) && TextUtils.isEmpty(address) && TextUtils.isEmpty(email) && TextUtils.isEmpty(phoneNo))
    }

}
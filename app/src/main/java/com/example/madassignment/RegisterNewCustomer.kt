package com.example.madassignment

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import com.example.madassignment.data.User
import com.example.madassignment.data.UserViewModel
import kotlinx.android.synthetic.main.activity_register_new_customer.*
import java.util.*

class RegisterNewCustomer : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_new_customer)

        val nameRegisterNewCustomer: TextView = findViewById(R.id.nameRegisterNewCustomer)
        val gender: Spinner = findViewById(R.id.genderSpinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.gender,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            gender.adapter = adapter
        }

        val memberType: Spinner = findViewById(R.id.memberTypeSpinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.membertype,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            gender.adapter = adapter
        }
        val dateOfBirth = Calendar.getInstance()
        val dateOfBirthYear = dateOfBirth.get(Calendar.YEAR)
        val dateOfBirthMonth = dateOfBirth.get(Calendar.MONTH)
        val dateOfBirthDate = dateOfBirth.get(Calendar.DAY_OF_MONTH)
        val btnPickDate: Button = findViewById(R.id.btnPickDate)
        val viewDOB: TextView = findViewById(R.id.dateOfBirthRegisterNewCustomer)

        btnPickDate.setOnClickListener {
            val dob = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        viewDOB.setText("" + dayOfMonth + "/" + (month + 1) + "/" + year)
                    },
                    dateOfBirthYear,
                    dateOfBirthMonth,
                    dateOfBirthDate
            )

            dob.show()
        }
        val spinnerGender: Spinner = findViewById(R.id.genderSpinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
                this,
                R.array.gender,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerGender.adapter = adapter
        }

        val spinnerMemberType: Spinner = findViewById(R.id.memberTypeSpinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
                this,
                R.array.membertype,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerMemberType.adapter = adapter
        }

    }



    fun onCLickCreate(view: View){

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        insertDataToDatabase()
    }

    private fun insertDataToDatabase() {
        val name = nameRegisterNewCustomer.text.toString()
        val gender =genderSpinner.selectedItem.toString()
        val icNo = icNoRegisterNewCustomer.text.toString()
        val age = ageRegisterNewCustomer.text.toString()
        val dateOfBirth = dateOfBirthRegisterNewCustomer.text.toString()
        val email = emailRegisterNewCustomer.text.toString()
        val phoneNo = phoneNoRegisterNewCustomer.text.toString()
        val memberType = memberTypeSpinner.selectedItem.toString()

        if(inputCheck(name,gender, icNo, age, dateOfBirth, email, phoneNo,memberType)){
            //Create User Object
            val user = User(0, name,gender, icNo, age, dateOfBirth, email, phoneNo,memberType)
            //Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(this, "Successfully added", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Please fill up all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String,gender:String, icNo: String, age: String, dateOfBirth: String, email: String, phoneNo: String,memberType:String): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(gender) && TextUtils.isEmpty(icNo) && TextUtils.isEmpty(age) && TextUtils.isEmpty(dateOfBirth) && TextUtils.isEmpty(email) && TextUtils.isEmpty(phoneNo) && TextUtils.isEmpty(memberType))
    }

}
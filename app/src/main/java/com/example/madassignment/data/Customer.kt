package com.example.madassignment.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_table")
data class Customer(
    @PrimaryKey(autoGenerate = true)
    val customerId: Int,
    val name: String,
    val gender:String,
    val icNo: String,
    val age: String,
    val dateOfBirth: String,
    val email: String,
    val phoneNo: String,
    val memberType :String
)

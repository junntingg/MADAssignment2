package com.example.madassignment.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
        @PrimaryKey(autoGenerate = true)
        val staffId: Int,
        val name: String,
        val icNo: String,
        val password: String,
        val address: String,
        val email: String,
        val phoneNo: String
)
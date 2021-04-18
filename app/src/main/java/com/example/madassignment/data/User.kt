package com.example.madassignment.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "user_table")

@Parcelize
data class User(
        @PrimaryKey(autoGenerate = true)
        val staffId: Int,
        val name: String,
        val icNo: String,
        val password: String,
        val address: String,
        val email: String,
        val phoneNo: String
): Parcelable
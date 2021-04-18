package com.example.madassignment.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCustomer(customer: Customer)

    @Query("SELECT * FROM customer_table ORDER BY customerId ASC")
    fun readAllData(): LiveData<List<Customer>>
}
package com.example.madassignment.data

import androidx.lifecycle.LiveData

class CustomerRepository(private val customerDao: CustomerDao) {

    val readAllData: LiveData<List<Customer>> = customerDao.readAllData()

    suspend fun addCustomer(customer: Customer){
        customerDao.addCustomer(customer)
    }
}
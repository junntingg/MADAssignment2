package com.example.madassignment.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Customer>>
    private val repository: CustomerRepository

    init {
        val customerDao = CustomerDatabase.getDatabase(application).customerDao()
        repository = CustomerRepository(customerDao)
        readAllData = repository.readAllData
    }

    fun addCustomer(customer: Customer){
        viewModelScope.launch (Dispatchers.IO){
            repository.addCustomer(customer)
        }
    }

}
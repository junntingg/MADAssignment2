package com.example.madassignment.data

import android.app.Application
import android.provider.ContactsContract
import android.service.autofill.UserData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun staffLogin(email: String, password: String){
        viewModelScope.launch (Dispatchers.IO){
            repository.staffLogin(email, password)
        }
    }

    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteUser(user)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteAllUsers()
        }
    }

}
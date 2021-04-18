package com.example.madassignment.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun staffLogin(email: String, password: String) {
        userDao.staffLogin(email, password)
    }

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}
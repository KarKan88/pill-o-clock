package com.example.pilloclock.data.repo

import com.example.pilloclock.data.dao.UserDao
import com.example.pilloclock.data.entity.User

class UserRepository (private val userDao: UserDao) {
    fun addUser(user: User){
        userDao.insertAll(user);
    }

    fun getUser():List<User> = userDao.getAll()
}
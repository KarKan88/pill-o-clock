package com.example.pilloclock.data.repo

import com.example.pilloclock.data.dao.NotificationDao
import com.example.pilloclock.data.entity.Notification

class NotificationRepository (private val notificationDao: NotificationDao) {
    fun addNotification(notification: Notification) = notificationDao.insertAll(notification)
    fun getNotification() = notificationDao.getAll()
}
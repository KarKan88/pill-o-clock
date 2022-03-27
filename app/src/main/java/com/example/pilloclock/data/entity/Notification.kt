package com.example.pilloclock.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pilloclock.constants.NotificationStatus
import java.sql.Timestamp

@Entity
data class Notification(
    @PrimaryKey
    val id: String,
    val text: String?,
    val status: NotificationStatus?,
    val timestamp: String?,
)

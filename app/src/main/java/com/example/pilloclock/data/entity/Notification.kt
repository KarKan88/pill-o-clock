package com.example.pilloclock.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notification(
    @PrimaryKey
    val id: String,
    val text: String?,
    val status: String?
)

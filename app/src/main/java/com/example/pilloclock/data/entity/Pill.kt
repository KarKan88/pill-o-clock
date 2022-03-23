package com.example.pilloclock.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pill(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val time: String?,
    val days: String?,
    val icon: String?,
    val startDate: String?,
    val endDate: String?,
    val dosage: String?,
    val pillsLeft: String?,
    val addedDate: String?,
    val description: String?,
    val notes: String?,
    val doctor: String?
)

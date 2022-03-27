package com.example.pilloclock.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pilloclock.data.entity.Pill

@Dao
interface PillDao {
    @Insert
    fun insertAll(vararg pill: Pill)

    @Delete
    fun delete(pill: Pill)

    @Query("SELECT * FROM pill")
    fun getAll(): List<Pill>
}
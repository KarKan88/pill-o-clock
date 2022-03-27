package com.example.pilloclock.data.repo

import com.example.pilloclock.data.dao.PillDao
import com.example.pilloclock.data.entity.Pill

class PillRepository(private val pillDao: PillDao) {
    fun addPill(pill: Pill) = pillDao.insertAll(pill)

    fun getUser():List<Pill> = pillDao.getAll()
}
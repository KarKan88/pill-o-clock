package com.example.pilloclock

import java.io.Serializable
import java.util.*

class PillModel : Observable(), Serializable {
    var id = ""
    var name = ""
    var brand = ""
    var time = ""
    var days = ""
    var icon = ""
    var startDate = ""
    var endDate = ""
    var dosage = ""
    var refill = false
    var pillsLeft = 0.0
    var addedDate = ""
    var description = ""
    var notes = ""
    var doctor = ""
}
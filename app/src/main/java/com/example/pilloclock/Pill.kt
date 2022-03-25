package com.example.pilloclock

import java.util.*

class PillModel : Observable() {
    var id = ""
    var name = ""
    var time = ""
    var days = ""
    var icon = ""
    var startDate = ""
    var endDate = ""
    var dosage = 0.0
    var pillsLeft = 0.0
    var addedDate = ""
    var description = ""
    var notes = ""
    var doctor = ""
}
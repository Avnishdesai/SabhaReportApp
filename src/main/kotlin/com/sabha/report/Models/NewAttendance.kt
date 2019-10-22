package com.sabha.report.Models

import java.util.*

data class NewAttendance(
        var mandal: String? = null,
        var center: String? = null,
        var person: Long? = null,
        var sabhaDate: Date? = null
)
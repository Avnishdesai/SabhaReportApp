package com.sabha.report.Services

import com.sabha.report.Models.Attendance
import java.sql.Date

interface IAttendanceService {
    fun findAll(): List<Attendance>

    fun save(
            mandal: String,
            center: String,
            person: Long,
            sabhaDate: String
    )
}
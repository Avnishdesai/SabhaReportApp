package com.sabha.report.Services

import com.sabha.report.Models.Attendance

interface IAttendanceService {
    fun findAll(): List<Attendance>
}
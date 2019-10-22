package com.sabha.report.Services

import com.sabha.report.Models.Attendance
import com.sabha.report.Repos.AttendaceRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AttendanceService: IAttendanceService {
    @Autowired
    private val repository: AttendaceRepo? = null

    override fun findAll(): List<Attendance> {
        return repository!!.findAll() as List<Attendance>
    }
}
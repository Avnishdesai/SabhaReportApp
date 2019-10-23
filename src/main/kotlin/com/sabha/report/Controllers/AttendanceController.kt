package com.sabha.report.Controllers

import com.sabha.report.Models.Attendance
import com.sabha.report.Models.Person
import com.sabha.report.Services.IAttendanceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.sql.Date


@RestController
class AttendanceController(@Autowired
                           private val attendanceService: IAttendanceService) {


    @GetMapping ("/showAttendance")
    fun getAttendance(model: Model): List<Attendance>
    {
        return attendanceService.findAll()
    }

    @PostMapping("/addAttendance")
    fun addAttendance(
            @RequestParam mandal: String,
            @RequestParam center: String,
            @RequestParam person: Long,
            @RequestParam sabhaDate: String
    ): List<Attendance>{
        attendanceService.save(
                        mandal = mandal,
                        center = center,
                        person = person,
                        sabhaDate = sabhaDate
        )
        return attendanceService.findAll()
    }
}
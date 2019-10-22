package com.sabha.report.Controllers

import com.sabha.report.Models.Attendance
import com.sabha.report.Models.NewAttendance
import com.sabha.report.Models.NewAttendee
import com.sabha.report.Services.AttendanceService
import com.sabha.report.Services.IAttendanceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class AttendanceController {
    @Autowired
    private val attendanceService: IAttendanceService? = null

    @GetMapping ("/showAttendance")
    fun getAttendance(model: Model): String
    {
        model.addAttribute("attendance", attendanceService!!.findAll())
        return "showAttendance"
    }

    @GetMapping("/addAttendance")
    fun getAttendanceForm(model: Model): String {

        return "addAttendance"
    }

    @PostMapping("/addAttendance")
    fun addAttendance(@ModelAttribute attendance: NewAttendee): String {
        print(attendance)

        return "showAttendance"
    }
}
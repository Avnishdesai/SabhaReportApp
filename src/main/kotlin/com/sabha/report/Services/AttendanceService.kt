package com.sabha.report.Services

import com.sabha.report.Models.Attendance
import com.sabha.report.Repos.AttendaceRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Date

@Service
class AttendanceService(
        @Autowired
        private val repository: AttendaceRepo,
        @Autowired
        private val personService: PersonService
    ): IAttendanceService {


    override fun findAll(): List<Attendance> {
        return repository.findAll().toList()
    }

    override fun save(mandal: String, center: String, person: Long, sabhaDate: String) {




        repository.save(
                Attendance(
                        id = null,
                        mandal = mandal,
                        center = center,
                        person = personService.findbyID(person),
                        sabhaDate = Date.valueOf(sabhaDate)
                )
        )
    }
}
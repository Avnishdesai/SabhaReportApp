package com.sabha.report.Repos

import com.sabha.report.Models.Attendance
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AttendaceRepo : CrudRepository<Attendance, Long>
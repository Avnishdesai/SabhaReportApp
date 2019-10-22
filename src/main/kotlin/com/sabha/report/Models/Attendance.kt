package com.sabha.report.Models

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "attendance")
data class Attendance(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,
        var mandal: String? = null,
        var center: String? = null,
        @ManyToOne
        @JoinColumn
        var person: Person? = null,
        var sabhaDate: Date? = null
)
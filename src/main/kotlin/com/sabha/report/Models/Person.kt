package com.sabha.report.Models

import javax.persistence.*

@Entity
@Table(name = "people")
data class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        var firstName: String? = null,
        var surname: String? = null
)
package com.sabha.report.Models


import javax.persistence.*


@Entity
@Table(name = "cities")
data class City (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    var name: String? = null,
    var population: Int = 0
)
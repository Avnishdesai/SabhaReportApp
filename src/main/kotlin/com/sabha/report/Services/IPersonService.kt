package com.sabha.report.Services

import com.sabha.report.Models.Person


interface IPersonService {

    fun findAll(): List<Person>

    fun findbyID(id: Long): Person?

    fun save(person: Person)
}
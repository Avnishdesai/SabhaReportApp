package com.sabha.report.Services

import com.sabha.report.Models.City


interface ICityService {

    fun findAll(): List<City>
}
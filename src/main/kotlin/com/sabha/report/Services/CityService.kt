package com.sabha.report.Services

import com.sabha.report.Models.City
import com.sabha.report.Repos.CityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CityService : ICityService {

    @Autowired
    private val repository: CityRepository? = null

    override fun findAll(): List<City> {

        return repository!!.findAll() as List<City>
    }
}
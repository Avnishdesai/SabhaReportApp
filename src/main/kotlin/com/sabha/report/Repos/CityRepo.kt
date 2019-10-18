package com.sabha.report.Repos

import com.sabha.report.Models.City
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface CityRepository : CrudRepository<City, Long>
package com.sabha.report.Repos

import com.sabha.report.Models.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepo : CrudRepository<Person, Long>{

}
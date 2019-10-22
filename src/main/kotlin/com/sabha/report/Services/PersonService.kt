package com.sabha.report.Services

import com.sabha.report.Models.Person
import com.sabha.report.Repos.PersonRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService: IPersonService {
    @Autowired
    private val repository: PersonRepo? = null

    override fun findAll(): List<Person> {
        return repository!!.findAll() as List<Person>
    }
}
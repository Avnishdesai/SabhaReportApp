package com.sabha.report.Services

import com.sabha.report.Models.Person
import com.sabha.report.Repos.PersonRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService(@Autowired
                    private val repository: PersonRepo): IPersonService {

    override fun findAll(): List<Person> {
        return repository.findAll().toList()

    }

    override fun findbyID(id: Long): Person? {
        val person = repository.findById(id)
        return person.get()
    }

    override fun save(person: Person) {
        repository.save(person)
    }
}
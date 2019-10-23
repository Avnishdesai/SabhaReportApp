package com.sabha.report.Controllers

import com.sabha.report.Models.Person
import com.sabha.report.Services.IPersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(@Autowired
                       private val personService: IPersonService) {

    @GetMapping("/getPeople")
    fun getPeople(): List<Person>{
        return personService.findAll()
    }

    @PostMapping("/addPerson")
    fun addPerson(
            @RequestParam firstName: String,
            @RequestParam surname: String
                  ): List<Person>{
        personService.save(
                Person(
                        id = 5,
                        firstName = firstName,
                        surname = surname
                )
        )
        return personService.findAll()
    }

}
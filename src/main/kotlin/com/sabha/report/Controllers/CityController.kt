package com.sabha.report.Controllers

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import com.sabha.report.Services.ICityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller


@Controller
class MyController {

    @Autowired
    private val cityService: ICityService? = null

    @GetMapping("/showCities")
    fun findCities(model: Model): String {

        model.addAttribute("cities", cityService!!.findAll())

        return "showCities"
    }
}
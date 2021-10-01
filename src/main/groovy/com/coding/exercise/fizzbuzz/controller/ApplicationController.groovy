package com.coding.exercise.fizzbuzz.controller

import com.coding.exercise.fizzbuzz.dto.FizzBuzzData
import com.coding.exercise.fizzbuzz.service.ApplicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ApplicationController {

    @Autowired
    ApplicationService applicationService

    @Autowired
    FizzBuzzData fizzBuzzData

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute('fizzBuzzData', fizzBuzzData)
        "index"
    }

    @PostMapping(value = 'calculate')
    void calculateValues(@ModelAttribute("fizzBuzzData") FizzBuzzData fizzBuzzData) {
        fizzBuzzData.outputValues = applicationService.displayCollectionValues(fizzBuzzData.inputValue?.trim()?.split("\\s*,\\s*"))
    }
}

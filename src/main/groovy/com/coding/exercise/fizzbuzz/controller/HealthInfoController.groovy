package com.coding.exercise.fizzbuzz.controller

import com.coding.exercise.fizzbuzz.service.HealthInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthInfoController {
    @Autowired
    HealthInfoService healthInfoService

    @GetMapping("heartbeat")
    Map heartbeat() {
        healthInfoService.healtCheckInfo()
    }
}

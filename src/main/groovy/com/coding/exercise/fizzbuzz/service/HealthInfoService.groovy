package com.coding.exercise.fizzbuzz.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.info.BuildProperties
import org.springframework.stereotype.Service

@Service
class HealthInfoService {

    @Autowired
    BuildProperties buildProperties

    Map healtCheckInfo() {
        return [
                name   : buildProperties.name,
                version: buildProperties.version
        ]
    }
}

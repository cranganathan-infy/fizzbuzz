package com.coding.exercise.fizzbuzz.service

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

@Service
@Slf4j
class ApplicationService {

    String[] displayCollectionValues(String[] inputValues) {
        List<String> displayList = []
        inputValues.each { it ->
            if (it.isInteger()) {
                int num = Integer.valueOf(it)
                if ((num % 5 == 0) && (num % 3 == 0)) {
                    log.debug('FizzBuzz')
                    displayList << 'FizzBuzz'
                } else if ((num % 3) == 0) {
                    log.debug('Fizz')
                    displayList << 'Fizz'
                } else if (num % 5 == 0) {
                    log.debug('Buzz')
                    displayList << 'Buzz'
                } else {
                    log.debug("Divided $num by 3")
                    displayList << "Divided $num by 3"
                    log.debug("Divided $num by 5")
                    displayList << "Divided $num by 5"
                }
            } else {
                log.debug('Invalid Item')
                displayList << 'Invalid Item'
            }
        }
        displayList?.toArray()
    }
}


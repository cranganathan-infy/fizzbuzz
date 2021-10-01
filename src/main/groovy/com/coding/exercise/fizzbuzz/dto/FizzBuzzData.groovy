package com.coding.exercise.fizzbuzz.dto

import org.springframework.stereotype.Component

@Component
class FizzBuzzData implements Serializable {
    String inputValue
    String[] outputValues
}

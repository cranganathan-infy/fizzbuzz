package com.coding.exercise.fizzbuzz.service

import org.springframework.boot.info.BuildProperties
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class ApplicationServiceSpec extends Specification {

    ApplicationService sut = new ApplicationService()

    def 'test displayCollection for #condition'() {

        when:
        String[] actualResults = sut.displayCollectionValues(testValues as String[])

        then:
        actualResults == expectedResults

        where:
        condition           | testValues                           | expectedResults
        'no value'          | []                                   | []
        'Fizz'              | ['3']                                | ['Fizz']
        'Bizz'              | ['5']                                | ['Buzz']
        'FizzBuzz'          | ['15']                               | ['FizzBuzz']
        'invalid'           | ['ABC']                              | ['Invalid Item']
        'float number'      | ['3.0']                              | ['Invalid Item']
        '-ve number'        | ['-5']                               | ['Buzz']
        'empty string'      | ['']                                 | ['Invalid Item']
        'some integer'      | ['23']                               | ['Divided 23 by 3', 'Divided 23 by 5']
        'all sample'        | ['1', '3', '5', '', '15', 'A', '23'] | ['Divided 1 by 3', 'Divided 1 by 5', 'Fizz', 'Buzz', 'Invalid Item', 'FizzBuzz', 'Invalid Item', 'Divided 23 by 3', 'Divided 23 by 5']

    }

}

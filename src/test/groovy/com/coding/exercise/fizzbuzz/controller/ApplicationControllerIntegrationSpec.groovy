package com.coding.exercise.fizzbuzz.controller

import com.coding.exercise.fizzbuzz.FizzbuzzApplicationAbstractIntegrationSpec
import com.coding.exercise.fizzbuzz.dto.FizzBuzzData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.web.context.WebApplicationContext
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

class ApplicationControllerIntegrationSpec extends FizzbuzzApplicationAbstractIntegrationSpec {

    @Autowired
    WebApplicationContext wac

    @Autowired
    ApplicationController sut

    MockMvc mockMvc

    def 'index page load'() {
        setup:
        mockMvc = webAppContextSetup(this.wac).build()

        when:
        MvcResult result = mockMvc.perform(get('/index')).andReturn()

        then:
        result.response.status == HttpStatus.OK.value()
        result.modelAndView.viewName == 'index'
    }

    @Unroll
    def 'Post to calculate page'() {
        setup:
        mockMvc = webAppContextSetup(this.wac).build()
        FizzBuzzData fizzBuzzData = new FizzBuzzData(inputValue: '15')
        String spaceResultHtml

        when: 'valid value'
        MvcResult result = mockMvc.perform(post('/calculate').flashAttr("fizzBuzzData", fizzBuzzData)).andReturn()

        then:
        result.response.status == HttpStatus.OK.value()
        result.response.contentAsString.contains('FizzBuzz')

        when: 'no value'
        MvcResult noResult = mockMvc.perform(post('/calculate').flashAttr("fizzBuzzData", new FizzBuzzData())).andReturn()

        then:
        noResult.response.status == HttpStatus.OK.value()
        noResult.response.contentAsString.contains("<label>Results:</label>")

        when: 'value with spaces'
        MvcResult spacesResult = mockMvc.perform(post('/calculate').flashAttr("fizzBuzzData", new FizzBuzzData(inputValue: " 3,5 , TEST "))).andReturn()

        then:
        spacesResult.response.status == HttpStatus.OK.value()
        print spacesResult.response.toString()
        spacesResult.response.contentAsString.contains("Fizz")
    }
}

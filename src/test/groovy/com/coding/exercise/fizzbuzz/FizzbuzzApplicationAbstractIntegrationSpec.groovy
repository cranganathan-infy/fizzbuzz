package com.coding.exercise.fizzbuzz

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest(classes = [FizzbuzzApplication], webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = FizzbuzzApplication, initializers = ConfigFileApplicationContextInitializer)
class FizzbuzzApplicationAbstractIntegrationSpec extends Specification{

	static {
		System.setProperty('environment', 'integration')
		System.setProperty('spring.main.allow-bean-definition-overriding', 'true')
	}
}

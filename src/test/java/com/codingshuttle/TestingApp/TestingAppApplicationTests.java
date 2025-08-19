package com.codingshuttle.TestingApp;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
@Slf4j
class TestingAppApplicationTests {

	@BeforeEach
	void setUp(){
		log.info("Setting the method, setting config");
	}

	@AfterEach
	void tearDown(){
		log.info("Tearing Down the method...");
	}

	@BeforeAll
	static void setUpOnce(){
		log.info("Setting up once");
	}

	@AfterAll
	static void tearDownOnce(){
		log.info("Tearing Down once");
	}

	@Test
	//@Disabled - For disabling test Method
	void testNumberOne(){
		log.info("Test one running");

		int a = 5;
		int b = 3;
		int result = addTwoNumbers(a,b);

		//assertions from Junit , cant use chaining , limited scope and functions
		//Assertions.assertEquals(7,result);

//		Assertions.assertThat(result)
//				.isEqualTo(7)
//				.isCloseTo(9, Offset.offset(1));

		Assertions.assertThat("Apple")
				.isEqualTo("Apple")
				.startsWith("Apz")
				.endsWith("e")
				.hasSize(5);
	}

	@Test
	//@DisplayName("displayNameTestTwo") - For Changing methodName
	void testDivideTwoNumbers_whenDenominatorIsZero_ThenArithMeticExceptions(){
		log.info("Test two running");
		int a = 5;
		int b= 0;

		Assertions.assertThatThrownBy(()->divideTwoNumbers(a,b))
				.isInstanceOf(NullPointerException.class)
				.hasMessage("Tried to divide By Zero");

	}

	int addTwoNumbers(int a , int b){
		return a+b;
	}

	double divideTwoNumbers(int a , int b){
		try {
			return a/b;
		}catch (ArithmeticException e){
			log.error("Arithmetic exception occured: "+e.getLocalizedMessage());
			throw new ArithmeticException("Tried to divide By Zero");
			//comment added
		}
	}

}

















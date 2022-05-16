package com.proyectocalendar.birthdaycalendar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class BirthdaycalendarApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void encrypt() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
	}
}

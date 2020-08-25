package com.dhar.restapi;

import com.dhar.restapi.controller.v1.api.TodoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
class RestapiApplicationTests {
	@Autowired
	private TodoController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
}

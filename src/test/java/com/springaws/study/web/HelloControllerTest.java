package com.springaws.study.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class) // JUnit 실행자 외 다른 실행자와 함께 실행. 스프링부트 테스트와 연동
@WebMvcTest(controllers = HelloController.class) // Web(Spring MVC) 테스트
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc; // 웹 API ( GET, POST 등) 테스트

	@Test
	public void helloTest() throws Exception {
		String hello = "hello";

		mvc.perform(get("/hello")) // GET 요청
				.andExpect(status().isOk()) // 결과 검증 http header code : 200
				.andExpect(content().string(hello)); // 결과 검증
	}

	@Test
	public void helloDtoTest() throws Exception {
		String name = "hello";
		int amount = 1000;

		mvc.perform(
				get("/hello/dto")
						.param("name", name)
						.param("amount", String.valueOf(amount)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(name)))
				.andExpect(jsonPath("$.amount", is(amount)));
	}
}

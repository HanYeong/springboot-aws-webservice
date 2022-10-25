package com.springaws.study.web;

import org.apache.catalina.security.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}

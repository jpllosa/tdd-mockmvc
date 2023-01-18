package com.blogspot.jpllosa.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MathFunControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getGcfTest() throws Exception {
		this.mockMvc.perform(get("/get-gcf?firstNumber=12&secondNumber=16"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.firstNumber", is(12)))
			.andExpect(jsonPath("$.secondNumber", is(16)))
			.andExpect(jsonPath("$.gcf", is(4)));
	}

}

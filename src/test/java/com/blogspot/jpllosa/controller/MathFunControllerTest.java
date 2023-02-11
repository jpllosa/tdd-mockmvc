package com.blogspot.jpllosa.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.blogspot.jpllosa.model.GreatestCommonFactor;
import com.blogspot.jpllosa.service.MathFunService;

@SpringBootTest
@AutoConfigureMockMvc
public class MathFunControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private MathFunController controller;
	
	@Mock
	private MathFunService service;
	
	@Test
	public void getGcfTest() throws Exception {
		this.mockMvc.perform(get("/get-gcf?firstNumber=12&secondNumber=16"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.firstNumber", is(12)))
			.andExpect(jsonPath("$.secondNumber", is(16)))
			.andExpect(jsonPath("$.gcf", is(4)));
	}

	@Test
	public void getGcfTestWithMockedService() throws Exception {
		GreatestCommonFactor gcf = new GreatestCommonFactor();
		gcf.setFirstNumber(12);
		gcf.setSecondNumber(16);
		gcf.setGcf(4);
		
		when(service.findGcf(12, 16)).thenReturn(gcf);
		GreatestCommonFactor actual = controller.getGcf(12, 16);
		
		verify(service).findGcf(anyInt(), anyInt());
		
		assertEquals(4, actual.getGcf());
	}
}

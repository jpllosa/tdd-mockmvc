package com.blogspot.jpllosa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogspot.jpllosa.controller.MathFunController;

@SpringBootTest
class TddWebLayerApplicationTests {
	
	@Autowired
	private MathFunController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}

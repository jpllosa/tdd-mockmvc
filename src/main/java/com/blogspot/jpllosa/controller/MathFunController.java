package com.blogspot.jpllosa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogspot.jpllosa.model.GreatestCommonFactor;
import com.blogspot.jpllosa.service.MathFunService;

@RestController
public class MathFunController {
	
	@Autowired
	private MathFunService service;

	@GetMapping("/get-gcf")
	public GreatestCommonFactor getGcf(@RequestParam int firstNumber, @RequestParam int secondNumber) {
		return service.findGcf(firstNumber, secondNumber);
	}
}

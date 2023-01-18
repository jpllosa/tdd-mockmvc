package com.blogspot.jpllosa.service;

import org.springframework.stereotype.Service;

import com.blogspot.jpllosa.model.GreatestCommonFactor;

@Service
public class MathFunService {

	public GreatestCommonFactor findGcf(int x, int y) {
		int result = getGCF(x, y);
		
		GreatestCommonFactor gcf = new GreatestCommonFactor();
		gcf.setFirstNumber(x);
		gcf.setSecondNumber(y);
		gcf.setGcf(result);
		
		return gcf;
	}
	
	public int getGCF(int x, int y) {
		return (y == 0) ? x : getGCF(y, x % y);
	}
}

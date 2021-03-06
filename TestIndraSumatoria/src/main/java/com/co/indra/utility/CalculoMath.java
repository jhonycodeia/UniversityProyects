package com.co.indra.utility;

import org.springframework.stereotype.Component;

@Component
public class CalculoMath {

	private int sumatoria(int num) {
		return (num)*(num+1);
	}
	
	public int valor(int first,int last) {
		return sumatoria((last-first)/2+1);
	}
}

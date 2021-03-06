package com.green.utility;

import org.springframework.stereotype.Component;

@Component
public class PasswordGenerator {

	private final String cadena = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,;.:-_{}[]*+-/¿¡?'=)(%#@|!";

	public  String password(int length) {
		
		String pswd = "";
 
		for (int i = 0; i < length; i++) {
			pswd+=(cadena.charAt((int)(Math.random() * cadena.length())));
		}
 
		return pswd;
	}
}

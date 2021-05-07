package com.co.microservicio.monitory.controller;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;



@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class MonitoryControllerIT {
	
	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public final void testMonitory() throws Exception {   
 
        HttpHeaders headers = new HttpHeaders();
        headers.set("user_id", "12345");  
         
        HttpEntity<?> requestEntity = new HttpEntity<>(null, headers);
         
        ResponseEntity<String> result = restTemplate.exchange("/monitory/register/52.93.28.94", HttpMethod.GET, requestEntity, String.class);
             
		
		String response = result.getBody();
		//"pais":"United States","codeISO":"US"
		JSONAssert.assertEquals("{\"pais\":\"United States\",\"codeISO\":\"US\"}", 
				response, false);
	}

}

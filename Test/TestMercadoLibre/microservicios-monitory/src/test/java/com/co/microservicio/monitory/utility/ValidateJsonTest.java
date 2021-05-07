package com.co.microservicio.monitory.utility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;


import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ValidateJsonTest {
	
	@Spy
	private RestTemplate restTemplate;
	
	@InjectMocks
	private ValidateJson validateJson;

	@Test
	void testAmazon() {
		try {
			String amazonjson = restTemplate.getForObject("https://ip-ranges.amazonaws.com/ip-ranges.json", String.class);
			
					
			List<JsonCondition> rule = Arrays.asList(new JsonCondition("prefixes.ip_prefix", "35.180.0.0"));
			String valor = validateJson.jsonGetCondition(amazonjson, "prefixes.ip_prefix", rule).toString();
			
			log.info("el valor es "+valor);
			
			assertThat(valor).isNotNull();

		}catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	
}

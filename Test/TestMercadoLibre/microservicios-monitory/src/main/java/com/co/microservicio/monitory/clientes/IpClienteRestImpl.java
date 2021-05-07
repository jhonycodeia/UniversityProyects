package com.co.microservicio.monitory.clientes;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.co.microservicio.monitory.dto.CountryDTO;
import com.co.microservicio.monitory.utility.DistanceUtility;
import com.co.microservicio.monitory.utility.JsonCondition;
import com.co.microservicio.monitory.utility.ValidateJson;

@Service
public class IpClienteRestImpl implements IpClienteRest {
	
	
	
	private static final String URL_COUNTRY = "https://api.ip2country.info/ip?";
	private static final String AMAZON_IP = "https://ip-ranges.amazonaws.com/ip-ranges.json";
	private static final String CORDENADAS = "http://api.worldbank.org/v2/country/%s?format=json";

	@Autowired
	private Tracer tracer;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ValidateJson validateJson;
	
	@Autowired
	private DistanceUtility distance;
	
	@Override
	public CountryDTO findCountry(String ip) {
		tracer.currentSpan().tag("findCountry.url", URL_COUNTRY.concat(ip));
		return restTemplate.getForObject(URL_COUNTRY.concat(ip), CountryDTO.class);
	}

	@Override
	public boolean findAmazon(String ip) throws Exception {	
		tracer.currentSpan().tag("findAmazon.url", AMAZON_IP);		
		
		String amazonjson = restTemplate.getForObject(AMAZON_IP, String.class);
		
		tracer.currentSpan().tag("findAmazon.response", amazonjson);
		
		List<JsonCondition> rule = Arrays.asList(new JsonCondition("prefixes.ip_prefix", ip));
		return validateJson.jsonGetCondition(amazonjson, "prefixes.ip_prefix", rule)!=null;
	}

	@Override
	public double distance(String iso) throws Exception {
		tracer.currentSpan().tag("distance.url", String.format(CORDENADAS, iso));		
		
		String json = restTemplate.getForObject(String.format(CORDENADAS, iso), String.class);
		
		tracer.currentSpan().tag("distance.response", json);
		
		Double longitud = Double.parseDouble(validateJson.jsonGet(json,"longitude").toString());
		Double latitude = Double.parseDouble(validateJson.jsonArray(json,"latitude").toString());
		
		return distance.distanciaCoord(latitude,longitud);
	}

}

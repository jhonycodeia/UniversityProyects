package com.co.microservicio.monitory.clientes;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.co.microservicio.monitory.dto.CountryDTO;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class IpClienteRestImplTest {
	
	@MockBean
	private IpClienteRest ipClienteRestImpl;

	@Test
	public final void testFindCountry() throws Exception {
		try {
			CountryDTO country = ipClienteRestImpl.findCountry("5.6.1.8");
			
			log.info("country "+country);
			
			assertThat(country).isNotNull();
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new RuntimeException("Error");
		}
	}
	
	@Test
	public final void testFindCountryFail() throws Exception {
		try {
			CountryDTO country = ipClienteRestImpl.findCountry("9.9.9.953");
			
			log.info("country "+country);
			
			assertThat(country).isNull();
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new RuntimeException("Error");
		}
	}


	@Test
	public final void testFindAmazon() throws Exception {
		try {
			assertThat(ipClienteRestImpl.findAmazon("35.180.0.0")).isFalse();
			
		}catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new RuntimeException("Error");
		}
	}
	
	@Test
	public final void testFindAmazonFail() throws Exception {
		try {
			assertThat(ipClienteRestImpl.findAmazon("35.180.0.140")).isFalse();
			
		}catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new RuntimeException("Error");
		}
	}

	@Test
	public void testDistance() throws Exception {
		try {
			double distance = ipClienteRestImpl.distance("CO");
			
			log.info("Distancia AR con CO "+distance+" Km");
			
			assertThat(distance).isNotNull();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new RuntimeException("Error");
		}
		
	}

}

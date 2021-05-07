package com.co.microservicio.monitory.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.microservicio.monitory.clientes.IpClienteRest;
import com.co.microservicio.monitory.dto.CountryDTO;
import com.co.microservicio.monitory.dto.IpDTO;
import com.co.microservicio.monitory.model.Ip;
import com.co.microservicio.monitory.repository.IpRepository;

import lombok.extern.slf4j.Slf4j;


@ExtendWith(MockitoExtension.class)
@Slf4j
public class IpServiceImplTest {
	
	@InjectMocks
	private IpServiceImpl ipServiceImpl;
	
	@Mock
	private IpClienteRest ipClienteRestImpl;

	@Mock
	private IpRepository repository;

	@Test
	public final void testMonitory() throws Exception {
		try {
			
			String ip = "1.1.1.1";
			Mockito.when(repository.findById(ip))
			.thenReturn(Optional.empty());
			
			Mockito.when(ipClienteRestImpl.findCountry(ip)).thenReturn(CountryDTO.builder()
					.countryCode("CO")
					.countryName("Colombia").build());
			Mockito.when(ipClienteRestImpl.findAmazon(ip)).thenReturn(true);
			Mockito.when(ipClienteRestImpl.distance("CO")).thenReturn(1200.0);
			
			IpDTO dato = ipServiceImpl.monitory(ip);
			
			log.info("IpDTO "+dato);
			
			assertThat(dato).isNotNull();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		
	}
	
	@Test
	public final void testMonitoryExist() throws Exception {
		
		String ip = "2.2.2.2";
		
		Mockito.when(repository.findById(ip))
		.thenReturn(Optional.of(Ip.builder()
				.ip("2.2.2.2")
				.fecha(new Date())
				.pais("Colombia")
				.codeISO("CO")
				.amazon(true)
				.distancia(1200.0)
				.invocaciones(12.0).build()));
		
		IpDTO dato = ipServiceImpl.monitory(ip);
		
		log.info("IpDTO "+dato);
		
		assertThat(dato).isNotNull();
		
		
	}

}

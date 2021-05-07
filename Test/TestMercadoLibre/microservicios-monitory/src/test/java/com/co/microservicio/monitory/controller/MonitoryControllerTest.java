package com.co.microservicio.monitory.controller;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.co.microservicio.monitory.dto.IpDTO;
import com.co.microservicio.monitory.model.Ip;
import com.co.microservicio.monitory.repository.IpRepository;
import com.co.microservicio.monitory.service.IpService;
import com.co.microservicio.monitory.service.UserService;
import com.co.microservicio.monitory.service.commons.CommonService;
import com.co.microservicio.monitory.utility.LoggerUtility;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(MonitoryController.class)
public class MonitoryControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userServiceImpl;
	
	@MockBean
	private IpService service;
	
	@MockBean
	private LoggerUtility loggerUser;


	@Test
	public final void testMonitory() throws Exception {
		
		Mockito.when(service.monitory("52.93.28.94"))
		.thenReturn(IpDTO.builder()
				.amazon(true)
				.ip("52.93.28.94")
				.codeISO("US")
				.pais("United States").build());
		
		RequestBuilder request = MockMvcRequestBuilders.get("/monitory/register/52.93.28.94").header("user_id","12345").accept(MediaType.APPLICATION_JSON);

		MvcResult response = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{\"ip\": \"52.93.28.94\",\"pais\": \"United States\"}")).andReturn();
		
		System.out.println(response.getResponse());
	}

}

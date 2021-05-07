package com.co.microservicio.monitory.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.microservicio.monitory.controller.commons.CommonController;
import com.co.microservicio.monitory.model.Ip;
import com.co.microservicio.monitory.model.User;
import com.co.microservicio.monitory.service.IpService;
import com.co.microservicio.monitory.service.UserService;
import com.co.microservicio.monitory.utility.LoggerUtility;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/monitory")
@Slf4j
public class MonitoryController extends CommonController<Ip,IpService> {

	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private LoggerUtility loggerUser;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register/{id}")
	public ResponseEntity<?> monitory(@RequestHeader("user_id") String user,@PathVariable String id) {
		try {
			if(user!=null) {
				User userEntity = User.builder().userId(user).hora(new Date()).build();
				userService.save(userEntity);
				loggerUser.logUser(userEntity.getUserId()+";"+userEntity.getHora());
			}
			log.info("EL puerto donde se esta recibiendo es "+port);
			return ResponseEntity.ok(service.monitory(id));
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/result/")
	public ResponseEntity<?> result() {
		try {
			return ResponseEntity.ok(service.resultados());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.notFound().build();
		}
	}
	
	

}

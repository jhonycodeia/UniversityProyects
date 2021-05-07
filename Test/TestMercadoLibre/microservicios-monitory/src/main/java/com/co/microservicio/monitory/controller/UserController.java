package com.co.microservicio.monitory.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.microservicio.monitory.controller.commons.CommonController;
import com.co.microservicio.monitory.model.User;
import com.co.microservicio.monitory.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController extends CommonController<User,UserService> {


}

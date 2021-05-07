package com.co.microservicio.monitory.service;


import org.springframework.stereotype.Service;
import com.co.microservicio.monitory.model.User;
import com.co.microservicio.monitory.repository.UserRepository;
import com.co.microservicio.monitory.service.commons.CommonServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Service
public class UserServiceImpl extends CommonServiceImpl<User,UserRepository> implements UserService {


}

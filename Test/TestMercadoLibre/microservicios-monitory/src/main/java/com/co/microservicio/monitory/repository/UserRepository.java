package com.co.microservicio.monitory.repository;

import org.springframework.data.repository.CrudRepository;

import com.co.microservicio.monitory.model.User;

public interface UserRepository extends CrudRepository<User,String>{

}

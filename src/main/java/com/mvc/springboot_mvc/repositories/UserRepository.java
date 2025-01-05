package com.mvc.springboot_mvc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mvc.springboot_mvc.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

    
}

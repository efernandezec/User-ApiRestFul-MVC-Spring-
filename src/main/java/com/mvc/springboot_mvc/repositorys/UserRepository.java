package com.mvc.springboot_mvc.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.mvc.springboot_mvc.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

    
}

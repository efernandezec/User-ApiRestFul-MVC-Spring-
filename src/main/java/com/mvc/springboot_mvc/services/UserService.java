package com.mvc.springboot_mvc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.springboot_mvc.models.User;
import com.mvc.springboot_mvc.repositorys.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById(long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public String getFullName(long userId){
        User user = userRepository.findById(userId).orElse(null);
        String fullName = user.getUsername().concat(" ").concat(user.getLastname());
        return fullName;
    }
    
    public List<User> list(){
        Iterable<User> users = userRepository.findAll();
        List<User> list = new ArrayList<User>();
        users.forEach(user -> list.add(user));
        return list;
    }

    public User create(User user){
        return userRepository.save(user);
    }



}

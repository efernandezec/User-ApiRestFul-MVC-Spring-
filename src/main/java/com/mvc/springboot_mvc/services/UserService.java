package com.mvc.springboot_mvc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.springboot_mvc.dto.UserDTO;
import com.mvc.springboot_mvc.models.User;
import com.mvc.springboot_mvc.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById(long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public String getFullName(long userId){
        User user = userRepository.findById(userId).orElse(null);
        String fullName = user.getFullName();
        return fullName;
    }
    
    public List<User> list(){
        Iterable<User> users = userRepository.findAll();
        List<User> list = new ArrayList<User>();
        users.forEach(user -> list.add(user));
        return list;
    }

    // Create sin UserDTO
    // public User create(User user){
    //     return userRepository.save(user);
    // }

    public User create(UserDTO userDTO){
        User user = new User(
            userDTO.getUsername(),
            userDTO.getLastname(),
            userDTO.getGender(),
            userDTO.getAge(),
            userDTO.getDatebirth()
            );
        return userRepository.save(user);
    }

    public User update(Long id, User userUpdate){
        return userRepository
        .findById(id)
        .map(user -> {
            user.setUsername(userUpdate.getUsername());
                user.setLastname(userUpdate.getLastname());
                user.setGender(userUpdate.getGender());
                user.setAge(userUpdate.getAge());
                user.setDatebirth(userUpdate.getDatebirth());

                return userRepository.save(user);
        })
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));

    }

    public void delete(Long id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
        System.out.println("User deleted with id: " + id);
    }



}

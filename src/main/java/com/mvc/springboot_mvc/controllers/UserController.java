package com.mvc.springboot_mvc.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.springboot_mvc.dto.UserDTO;
import com.mvc.springboot_mvc.models.User;
import com.mvc.springboot_mvc.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("api")
public class UserController {
    
    @Autowired
    private UserService userService;

    // Post sin UserDTO
    // @PostMapping("/user")
    // public User create(@RequestBody User user) {
    //     System.out.println(user.toString());
    //     User newUser = userService.create(user);
    //     return newUser;
    // }

    @PostMapping("/user")
    public User create(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.toString());
        User newUser = userService.create(userDTO);
        return newUser;
    }

    @GetMapping("/user")
    public List<User> users() {
        List<User> users = userService.list();
        return users;
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable Long id) {
        User user = userService.getById(id);
        return user;
    }

    @GetMapping("/user/{id}/fullname")
    public String fullName(@PathVariable long id) {

        String fullname = userService.getFullName(id);
        return fullname;
    }

    @PutMapping("user/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {    
        User userUpdate= userService.update(id, user);
        return userUpdate;
    }

    @DeleteMapping("user/{id}")
    public void updateUser(@PathVariable long id) {    
        userService.delete(id);
        System.out.println("Deleted user");
    }
}

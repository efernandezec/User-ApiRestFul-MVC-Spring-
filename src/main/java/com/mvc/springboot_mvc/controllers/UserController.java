package com.mvc.springboot_mvc.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mvc.springboot_mvc.models.User;
import com.mvc.springboot_mvc.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("api")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        System.out.println(user.toString());
        User newUser = userService.create(user);
        return newUser;
    }

    @GetMapping("/users")
    public List<User> users() {
        List<User> users = userService.list();
        return users;
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable Long id) {
        User user = userService.getById(id);
        return user;
    }

    @GetMapping("/user/fullname/{id}")
    public String fullName(@PathVariable long id) {

        String fullname = userService.getFullName(id);
        return fullname;
    }
}

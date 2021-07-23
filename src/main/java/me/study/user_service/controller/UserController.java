package me.study.user_service.controller;

import me.study.user_service.dto.request.NewUserRequest;
import me.study.user_service.model.User;
import me.study.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User createNewUser(@RequestBody NewUserRequest user) {
        return userService.createNewUser(user.username(), user.email());
    }

    @GetMapping("/test")
    public String test() {
        return "Just testing...";
    }

}

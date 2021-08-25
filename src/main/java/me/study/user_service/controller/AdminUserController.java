package me.study.user_service.controller;

import me.study.user_service.dto.request.NewUserRequest;
import me.study.user_service.model.User;
import me.study.user_service.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin/users")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping
    public List<User> getAllUsers() {
        return adminUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return adminUserService.getUser(id);
    }

    @PostMapping
    public User createNewUser(@RequestBody NewUserRequest user) {
        return adminUserService.createNewUser(user.username(), user.email());
    }

    @PutMapping
    public User enableUser(@RequestParam String username) {
        return adminUserService.enableUser(username);
    }

    @DeleteMapping
    public User disableUser(@RequestParam String username) {
        return adminUserService.disableUser(username);
    }

}

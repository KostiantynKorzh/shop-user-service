package me.study.user_service.service;

import me.study.user_service.model.User;
import me.study.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService {

    @Autowired
    private UserRepository userRepository;

    public User createNewUser(String username, String email) {
        return userRepository.save(User.builder()
                .username(username)
                .email(email)
                .build());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No such user: " + id));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new RuntimeException("No such user: " + username));
    }

    public User disableUser(String username) {
        User user = getUserByUsername(username);
        user.setEnabled(false);
        userRepository.save(user);
        return user;
    }

    public User enableUser(String username) {
        User user = getUserByUsername(username);
        user.setEnabled(true);
        userRepository.save(user);
        return user;
    }

}
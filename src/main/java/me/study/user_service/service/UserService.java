package me.study.user_service.service;

import me.study.user_service.model.User;
import me.study.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

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
                new RuntimeException("No such user"));
    }

}

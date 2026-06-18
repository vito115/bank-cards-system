package com.example.bankcards.service;

import com.example.bankcards.dto.UserDTO;
import com.example.bankcards.entity.User;
import com.example.bankcards.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO register(String email, String rawPassword, String role) {
        User user = new User(email, rawPassword, role);
        User saved = userRepository.save(user);
        return new UserDTO(saved.getId(), saved.getEmail(), saved.getRole());
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public UserDTO getUserDto(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getRole());
    }
}

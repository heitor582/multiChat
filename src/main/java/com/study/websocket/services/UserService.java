package com.study.websocket.services;

import com.study.websocket.entity.User;
import com.study.websocket.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> getUserByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        // Lógica para validar e criar um novo usuário
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        // Lógica para excluir um usuário
        userRepository.deleteById(userId);
    }
}

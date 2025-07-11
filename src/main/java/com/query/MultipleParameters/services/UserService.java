package com.query.MultipleParameters.services;


import com.query.MultipleParameters.entities.User;
import com.query.MultipleParameters.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Find by username and email
    public Optional<User> getUserByUsernameAndEmail(String username, String email) {
        return userRepository.findByUsernameAndEmail(username, email);
    }

    // Find by role and email
    public List<User> getUsersByRoleAndEmail(String role, String email) {
        return userRepository.findByRoleAndEmail(role, email);
    }

    // Find by username and role (custom JPQL)
    public List<User> getUsersByUsernameAndRole(String username, String role) {
        return userRepository.findByUsernameAndRole(username, role);
    }

    // Find by email and role (native SQL)
    public List<User> getUsersByEmailAndRoleNative(String email, String role) {
        return userRepository.findByEmailAndRoleNative(email, role);
    }
}

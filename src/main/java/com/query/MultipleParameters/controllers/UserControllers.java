package com.query.MultipleParameters.controllers;


import com.query.MultipleParameters.entities.User;
import com.query.MultipleParameters.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserControllers {

    @Autowired
    private UserService userService;

    // Endpoint 1: Find by username and email
    @GetMapping("/by-username-email")
    public ResponseEntity<User> getUserByUsernameAndEmail(
            @RequestParam String username,
            @RequestParam String email) {
        Optional<User> user = userService.getUserByUsernameAndEmail(username, email);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint 2: Find by role and email
    @GetMapping("/by-role-email")
    public ResponseEntity<List<User>> getUsersByRoleAndEmail(
            @RequestParam String role,
            @RequestParam String email) {
        List<User> users = userService.getUsersByRoleAndEmail(role, email);
        return ResponseEntity.ok(users);
    }

    // Endpoint 3: Find by username and role (JPQL)
    @GetMapping("/by-username-role")
    public ResponseEntity<List<User>> getUsersByUsernameAndRole(
            @RequestParam String username,
            @RequestParam String role) {
        List<User> users = userService.getUsersByUsernameAndRole(username, role);
        return ResponseEntity.ok(users);
    }

    // Endpoint 4: Find by email and role (Native SQL)
    @GetMapping("/by-email-role-native")
    public ResponseEntity<List<User>> getUsersByEmailAndRoleNative(
            @RequestParam String email,
            @RequestParam String role) {
        List<User> users = userService.getUsersByEmailAndRoleNative(email, role);
        return ResponseEntity.ok(users);
    }

}

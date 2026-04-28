package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User(1L, "Alice Smith",  "alice@qognition.io", "admin"));
        USERS.add(new User(2L, "Bob Jones",    "bob@qognition.io",   "viewer"));
        USERS.add(new User(3L, "Carol White",  "carol@qognition.io", "editor"));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return USERS;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = USERS.stream()
            .filter(u -> u.getId().equals(id))
            .findFirst();
        return user.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        return USERS.stream()
            .filter(u -> u.getRole().equalsIgnoreCase(role))
            .toList();
    }
}

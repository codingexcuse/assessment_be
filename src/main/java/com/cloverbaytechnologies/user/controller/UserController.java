package com.cloverbaytechnologies.user.controller;

import com.cloverbaytechnologies.user.model.User;
import com.cloverbaytechnologies.user.request.UserRequest;
import com.cloverbaytechnologies.user.response.UserResponse;
import com.cloverbaytechnologies.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/get/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId){
        UserResponse response = userService.getUserById(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<List<UserResponse>> getUser() {
        List<UserResponse> response = userService.getUsers();
        return ResponseEntity.ok(response);
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid UserRequest user) {
        User response = userService.addUser(user);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/edit/{userId}")
    public ResponseEntity<User> edituser(@PathVariable Long userId,
                         @RequestBody @Valid UserRequest user) {
        User response = userService.editUser(userId, user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/firstNameFilter")
    public List<User> firstNameFilter(@RequestParam String firstName) {
        return userService.firstNameFilter(firstName);
    }


    @GetMapping("/lastNameFilter")
    public List<User> lastNameFilter(@RequestParam String lastName) {
        return userService.lastNameFilter(lastName);
    }

    @GetMapping("/emailFilter")
    public Optional<User> emailFilter(@RequestParam String email) {
        return userService.emailFilter(email);
    }
}

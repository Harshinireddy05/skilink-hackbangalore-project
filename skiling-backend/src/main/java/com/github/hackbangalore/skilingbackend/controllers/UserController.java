package com.github.hackbangalore.skilingbackend.controllers;

import com.github.hackbangalore.skilingbackend.models.User;
import com.github.hackbangalore.skilingbackend.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userID}")
    public User getUser(@PathVariable String userID) throws ExecutionException, InterruptedException {
        return userService.getUser(userID);
    }

    @PostMapping
    public User createUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.createUser(user);
    }
    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}

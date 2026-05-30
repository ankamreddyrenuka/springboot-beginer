package com.anasuryareddy.WebProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anasuryareddy.WebProject.model.User;
import com.anasuryareddy.WebProject.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private UserService userService;
    public UserController(){
        userService = new UserService();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(
        @PathVariable int id,
        @RequestBody User u)
    {
        return ResponseEntity.ok(userService.updateUser(id, u));
    }

    @PostMapping
    public ResponseEntity<User> create(
        @RequestBody User u)
    {
        User cu = userService.createUser(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(cu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(
        @PathVariable int id)
    {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
}
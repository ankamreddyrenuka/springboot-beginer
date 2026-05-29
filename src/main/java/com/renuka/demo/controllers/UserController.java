package com.renuka.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.renuka.demo.model.User;
import com.renuka.demo.services.UserService;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "User management API")
public class UserController {

    UserService userService;

    public UserController() {
        userService = new UserService();
    }

    @GetMapping
    @Operation(summary = "Get all users", description = "Retrieve all saved users")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved users",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
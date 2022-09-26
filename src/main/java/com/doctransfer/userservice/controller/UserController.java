package com.doctransfer.userservice.controller;

import com.doctransfer.userservice.exception.UserNotFoundException;
import com.doctransfer.userservice.model.User;
import com.doctransfer.userservice.model.request.CreateUserRequest;
import com.doctransfer.userservice.model.response.ErrorResponse;
import com.doctransfer.userservice.model.response.ErrorType;
import com.doctransfer.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get a user by their user ID", description = "Get a user by their user ID")
    @ApiResponse(
            responseCode="200",
            description="Successfully got user.",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    @ApiResponse(
            responseCode="404",
            description="User not found.",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(
            @PathVariable Long userId
    ) {
        try {
            User user = userService.getUser(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage(), ErrorType.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Create a user", description = "Create a user")
    @ApiResponse(
            responseCode="201",
            description="Successfully created user.",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    @PostMapping("/")
    public ResponseEntity<?> createUser(
            @RequestBody CreateUserRequest createUserRequest
    ) {
        User user = userService.createUser(createUserRequest.toCoreModel());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}

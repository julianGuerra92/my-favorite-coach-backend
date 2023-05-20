package com.myfavoritecoach.rest.webservices.controller;

import com.myfavoritecoach.rest.webservices.Service.UserService;
import com.myfavoritecoach.rest.webservices.dto.LoginFormDto;
import com.myfavoritecoach.rest.webservices.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginFormDto loginForm) {
        var user = userService.findByEmail(loginForm.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (!user.getPassword().equals(loginForm.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(user);
    }


}

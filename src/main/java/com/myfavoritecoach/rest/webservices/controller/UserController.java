package com.myfavoritecoach.rest.webservices.controller;

import com.myfavoritecoach.rest.webservices.Service.UserService;
import com.myfavoritecoach.rest.webservices.dto.LoginFormDto;
import com.myfavoritecoach.rest.webservices.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<User>> findAll() {
        var userList = userService.findAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping()
    public ResponseEntity<Optional<User>> findById(@RequestParam Integer id) {
        var user = userService.findById(id);
        if(user.isEmpty()) {
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

}

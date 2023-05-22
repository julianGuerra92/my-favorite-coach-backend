package com.myfavoritecoach.rest.webservices.controller;

import com.myfavoritecoach.rest.webservices.Service.UserService;
import com.myfavoritecoach.rest.webservices.model.Role;
import com.myfavoritecoach.rest.webservices.model.User;
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

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        var userList = userService.findAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<User>> findById(@RequestParam Integer id) {
        var user = userService.findById(id);
        if(user.isEmpty()) {
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/find-by-role")
    public ResponseEntity<List<User>> findByRole(@RequestParam String description) {
        var userList = userService.findByRole(description);
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/count-by-description")
    public ResponseEntity<Long> countByDescription(@RequestParam String description) {
        var quantity = userService.countByDescription(description);
        return ResponseEntity.ok(quantity);
    }

    @PostMapping("/create-client")
    public ResponseEntity<User> createClient(@RequestBody User user){
        user.setRole(new Role(3, "client"));
        user.setActive(true);
        var newClient = userService.createUser(user);
        return ResponseEntity.ok(newClient);
    }

    @PutMapping("/update-client")
    public ResponseEntity<User> updateClient(@RequestBody User user) {
        var client = userService.updateUser(user);
        return  ResponseEntity.ok(client);
    }

}

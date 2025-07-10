package me.juhokim.controller;


import me.juhokim.domain.User;
import me.juhokim.dto.UserRequest;
import me.juhokim.dto.UserResponse;
import me.juhokim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    // Password Hidden (With DTO)
    @GetMapping("/credentials/users")
    ResponseEntity<List<UserResponse>> getUsers(){
        List<User> users = userService.findAll();
        List<UserResponse> response = users.stream()
                                            .map(UserResponse::new)
                                            .toList();

        return ResponseEntity.ok(response);
    }


    // Password Revealed (Without DTO)
    @GetMapping("credentials/users/{id}")
    ResponseEntity<User> getUser(@PathVariable long id){
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    // Prevent wrong password format (With DTO)
    @PostMapping("credentials/users")
    ResponseEntity<User> createUser(@RequestBody UserRequest request){
        User newUser = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

}

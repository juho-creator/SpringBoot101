package me.juhokim.dto;

import lombok.Getter;
import me.juhokim.domain.User;


// User Entity -> Object with password hidden
@Getter
public class UserResponse {
    String username;
    String passwordHash;


    // Hide the password
    public UserResponse(User user){
        this.username = user.getUsername();
        this.passwordHash = "*".repeat(user.getPassword().length());
    }
}

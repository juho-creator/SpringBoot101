package me.juhokim.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import me.juhokim.domain.User;

// Json -> User (with formatted password)
@AllArgsConstructor
@Getter
public class UserRequest {
    String username;
    String password;

    // Prevent password less than 8 characters
    public User toEntity(){
        if (password.length() < 8){
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}

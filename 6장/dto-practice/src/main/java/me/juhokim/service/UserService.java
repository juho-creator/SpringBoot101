package me.juhokim.service;


import me.juhokim.domain.User;
import me.juhokim.dto.UserRequest;
import me.juhokim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // Return all user credentials (password hidden)
    public List<User> findAll(){
        return userRepository.findAll();
    }

    // Return user credential (password revealed)
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found " + id));
    }


    // Add user credentials (restrict certain password)
    public User save(UserRequest request){
        return userRepository.save(request.toEntity());
    }
}

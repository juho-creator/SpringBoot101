package me.juhokim.SpringApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    FriendRepository friendRepository;

    List<Friend>getFriends(){
        return friendRepository.findAll();
    }
}

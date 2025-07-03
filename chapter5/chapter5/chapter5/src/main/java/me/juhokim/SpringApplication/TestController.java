package me.juhokim.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController{
    @Autowired
    FriendService friendService;

    @GetMapping("friends")
    List<Friend> getFriends(){
        List<Friend> friends = friendService.getFriends();
        return friends;
    }
}

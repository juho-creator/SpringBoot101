package me.juhokim.SpringBootApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    List<Dream> getDream(){
        return testRepository.findAll();
    }
}

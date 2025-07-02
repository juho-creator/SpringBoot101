package me.juhokim.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/dreams")
    List<Dream> getDream(){
        List<Dream> dreams = testService.getDream();
        return dreams;
    }
}

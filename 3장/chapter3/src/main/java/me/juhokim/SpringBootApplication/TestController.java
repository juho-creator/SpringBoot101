package me.juhokim.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// 프레젠테이션 계층 (컨트롤러)
@RestController
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("my_fam")
    List<Family> getFam(){
        List<Family> family_members = testService.getFam();
        return family_members;
    }
}

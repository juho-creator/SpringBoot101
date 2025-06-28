package me.juhokim.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


// 비즈니스 계층 (서비스)
@Service
public class TestService {
    @Autowired
    FamilyRepository familyRepository;

    List<Family> getFam() {
        return familyRepository.findAll();
    }
}
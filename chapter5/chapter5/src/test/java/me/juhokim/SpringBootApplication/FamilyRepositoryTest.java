package me.juhokim.SpringBootApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FamilyRepositoryTest {
    @Autowired
    FamilyRepository familyRepository;

    @Sql("/insert-members.sql") // 쿼리문 실행
    @Test  // INSERTING 1 item
    void getAllMembers(){
        //  when
        familyRepository.save(new Family(1L,"Juhooray"));


        List<Family> family_members = familyRepository.findAll();

        // then
        assertThat(familyRepository.findById(1L).get().getName()).isEqualTo("Juhooray");
    }

    @Test // INSERTING multiple items
    void saveMembers(){
        List<Family> family_members = List.of(new Family(2L, "BMO"), new Family(3L, "Jake"));

        familyRepository.saveAll(family_members);

        assertThat(familyRepository.findAll().size()).isEqualTo(2);
    }

    // Deleting by ID
    @Sql("/insert-members.sql") // 쿼리문 실행
    @Test
    void deleteMemberById(){
        familyRepository.deleteById(2L);
        assertThat(familyRepository.findById(2L).isEmpty()).isTrue();
    }

    // Deleting by ID
    @Sql("/insert-members.sql") // 쿼리문 실행
    @Test
    void deleteALl(){
        familyRepository.deleteAll();
        assertThat(familyRepository.findAll().size()).isZero();
    }

    @Sql("/insert-members.sql") // 쿼리문 실행
    @Test  // UPDATE family SET name = 'BC' WHERE id = 2;
    void update(){
        Family fam = familyRepository.findById(2L).get();
        fam.changeName("BC");
        assertThat(familyRepository.findById(2L).get().getName()).isEqualTo("BC");
    }
}
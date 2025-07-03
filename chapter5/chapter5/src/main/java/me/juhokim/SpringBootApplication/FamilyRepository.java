package me.juhokim.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// 퍼시스턴스 (리포지토리)
@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
    Optional<Family> findByName(String name);
}

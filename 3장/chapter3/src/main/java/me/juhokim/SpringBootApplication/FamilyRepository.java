package me.juhokim.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 퍼시스턴스 (리포지토리)
@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
}

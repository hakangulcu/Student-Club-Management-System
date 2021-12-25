package cs319.spring.proje.berk.repository;

import cs319.spring.proje.berk.entity.ClubAdvisor;
import cs319.spring.proje.berk.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubAdvisorRepository extends JpaRepository<ClubAdvisor, Long> {
    ClubAdvisor findClubAdvisorByEmail(String email);
}

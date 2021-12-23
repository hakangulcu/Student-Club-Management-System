package cs319.spring.proje.berk.repository;

import cs319.spring.proje.berk.entity.ClubManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubManagerRepository extends JpaRepository<ClubManager, Long> {
    public ClubManager findClubManagerByEmail(String email);
}

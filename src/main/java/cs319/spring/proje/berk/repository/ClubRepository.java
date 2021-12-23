package cs319.spring.proje.berk.repository;

import cs319.spring.proje.berk.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    // public Club findClubByName(String clubName);
    public Club findByClubName(String clubName);
}

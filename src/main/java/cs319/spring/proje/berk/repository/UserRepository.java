package cs319.spring.proje.berk.repository;

import cs319.spring.proje.berk.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByEmail(String email);
    /* public List<ClubAdvisor> findAllByAdvisorTrue();
    public List<User> findAllByAdminTrue();
    public List<User> findAllByManagerTrue();

     */
}

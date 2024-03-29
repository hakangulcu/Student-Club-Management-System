package cs319.spring.proje.berk.repository;

import cs319.spring.proje.berk.entity.Admin;
import cs319.spring.proje.berk.entity.ClubAdvisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByEmail(String email);
}

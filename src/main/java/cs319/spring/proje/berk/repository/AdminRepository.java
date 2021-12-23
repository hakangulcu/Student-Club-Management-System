package cs319.spring.proje.berk.repository;

import cs319.spring.proje.berk.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}

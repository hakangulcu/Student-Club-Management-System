package cs319.spring.proje.berk.repository;

import cs319.spring.proje.berk.entity.VisualElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisualElementRepository extends JpaRepository<VisualElement, Long> {
}

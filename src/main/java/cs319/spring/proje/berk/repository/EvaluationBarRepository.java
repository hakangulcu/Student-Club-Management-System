package cs319.spring.proje.berk.repository;

import cs319.spring.proje.berk.entity.EvaluationBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationBarRepository extends JpaRepository<EvaluationBar, Long> {

}

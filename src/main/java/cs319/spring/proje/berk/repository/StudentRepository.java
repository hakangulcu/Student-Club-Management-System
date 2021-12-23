package cs319.spring.proje.berk.repository;

import cs319.spring.proje.berk.entity.Student;
import cs319.spring.proje.berk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findStudentByEmail(String email);
}

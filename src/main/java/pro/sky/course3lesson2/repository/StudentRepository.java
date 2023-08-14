package pro.sky.course3lesson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.course3lesson2.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

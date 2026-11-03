package in.jatint4r.springbootcrudoperations.repository;

import in.jatint4r.springbootcrudoperations.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student,Long> {

}

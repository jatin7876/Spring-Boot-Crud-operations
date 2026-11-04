package in.jatint4r.springbootcrudoperations.repository;

import in.jatint4r.springbootcrudoperations.dto.StudentResponseDto;
import in.jatint4r.springbootcrudoperations.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student,Long> {
   Optional<Student> findByIdAndDeletedIsFalse(Long id);
   List<Student> findByAndDeletedIsFalse();

}

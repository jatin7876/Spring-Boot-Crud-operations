package in.jatint4r.springbootcrudoperations.repository;

import in.jatint4r.springbootcrudoperations.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {
    public void addNewStudent(Student student){
        System.out.println(student.getEmail());
        System.out.println(student.getName());
    }
}

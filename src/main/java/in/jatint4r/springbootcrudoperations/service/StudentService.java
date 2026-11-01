package in.jatint4r.springbootcrudoperations.service;

import in.jatint4r.springbootcrudoperations.entity.Student;
import in.jatint4r.springbootcrudoperations.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public void createnewStudent(Student student){
        System.out.println("In Student Service ");
        studentRepository.addNewStudent(student);

    }
}


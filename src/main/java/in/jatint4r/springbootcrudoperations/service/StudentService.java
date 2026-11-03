package in.jatint4r.springbootcrudoperations.service;

import in.jatint4r.springbootcrudoperations.entity.Student;
import in.jatint4r.springbootcrudoperations.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){

        this.studentRepository = studentRepository;
    }

    public Student createnewStudent(Student student){
        return studentRepository.save(student);

    }

    public Student getStudent(Long Id){
        Optional<Student> student= studentRepository.findById(Id);
        if(student.isPresent())
            return student.get();
        return null;
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}


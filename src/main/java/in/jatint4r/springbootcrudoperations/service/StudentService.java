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

    public Student updateStudent(Long id,Student studentReq){
       Optional<Student> student = studentRepository.findById(id);
       if(student.isEmpty()) return null;
       Student exsistingStudent=student.get();
        exsistingStudent.setAge(studentReq.getAge());
        exsistingStudent.setEmail(studentReq.getEmail());
        exsistingStudent.setName(studentReq.getName());
        exsistingStudent.setRollNo(studentReq.getRollNo());
        exsistingStudent.setSubject(studentReq.getSubject());

       return studentRepository.save(studentReq);
    }

    public boolean deleteStudent(Long id){
        boolean student = studentRepository.existsById(id);
        if(!student) return false;
        studentRepository.deleteById(id);
        return true;
    }

}


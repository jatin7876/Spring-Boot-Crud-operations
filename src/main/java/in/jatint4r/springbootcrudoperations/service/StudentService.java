package in.jatint4r.springbootcrudoperations.service;

import in.jatint4r.springbootcrudoperations.dto.StudentRequestDto;
import in.jatint4r.springbootcrudoperations.dto.StudentResponseDto;
import in.jatint4r.springbootcrudoperations.entity.Student;
import in.jatint4r.springbootcrudoperations.exception.DuplicateException;
import in.jatint4r.springbootcrudoperations.exception.ResourceNotFoundException;
import in.jatint4r.springbootcrudoperations.repository.StudentRepository;
import org.hibernate.sql.model.internal.OptionalTableInsert;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){

        this.studentRepository = studentRepository;
    }

    public StudentResponseDto createnewStudent(StudentRequestDto studentRequestDto){
        Student student= mapStudentEntity(studentRequestDto);
        if (checkDuplicateEmail(student))
            throw new DuplicateException("Email already Exists" + student.getEmail());
        Student createdStudent = studentRepository.save(student);
        StudentResponseDto studentResponse = mapentityToDto(createdStudent);
        return studentResponse;

    }

    public String dummyMethod(){
        System.out.println("dummy Method called");
//        throw new RuntimeException("Some Error Occurred");
          return "dummy Method ";
    }

    public StudentResponseDto getStudent(Long Id){
        Student student = studentRepository.
                findById(Id).
                orElseThrow(()-> new ResourceNotFoundException("Student with id " + Id + "Not found"));
        return mapentityToDto(student) ;
    }

    public List<StudentResponseDto> getAllStudents(){
        List<Student> student= studentRepository.findByAndDeletedIsFalse();
        return student.stream()
                .map(this::mapentityToDto)
                .toList();
    }

    public Student updateStudent(Long id,Student studentReq){
      Student student = studentRepository.
              findById(id).
              orElseThrow(()-> new ResourceNotFoundException("Student with id"  + id + "Not found"));
        student.setAge(studentReq.getAge());
        student.setEmail(studentReq.getEmail());
        student.setName(studentReq.getName());
        student.setRollNo(studentReq.getRollNo());
        student.setSubject(studentReq.getSubject());

       return studentRepository.save(studentReq);
    }

    public void deleteStudent(Long id){
         Student studentToDeleted =studentRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student with id"  + id + "Not found"));
        studentRepository.delete(studentToDeleted);
    }
    public void softDeleteStudent(Long id){
     Student student= studentRepository
             .findByIdAndDeletedIsFalse(id)
             .orElseThrow(()->new ResourceNotFoundException("Student with id"  + id + "Not found"));
     student.setDeleted(true);
     studentRepository.save(student);

    }
    private Student mapStudentEntity(StudentRequestDto studentRequestDto){
        Student student=new Student();
        student.setDeleted(false);
        student.setSubject(studentRequestDto.getSubject());
        student.setRollNo(studentRequestDto.getRollNo());
        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setAge(studentRequestDto.getAge());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }
    private StudentResponseDto mapentityToDto(Student student){
        StudentResponseDto studentResponseDto= new StudentResponseDto();
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setId(student.getId());
        studentResponseDto.setRollNo(student.getRollNo());
        studentResponseDto.setSubject(student.getSubject());
        studentResponseDto.setMessage("Successfully Created the Student");
        studentResponseDto.setCreatedAt(student.getCreatedAt());
        studentResponseDto.setUpdatedAt(student.getUpdatedAt());

        return studentResponseDto;
    }
    private Boolean checkDuplicateEmail(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }
}


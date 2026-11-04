package in.jatint4r.springbootcrudoperations.service;

import in.jatint4r.springbootcrudoperations.dto.StudentRequestDto;
import in.jatint4r.springbootcrudoperations.dto.StudentResponseDto;
import in.jatint4r.springbootcrudoperations.entity.Student;
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
        Student createdStudent = studentRepository.save(student);
        StudentResponseDto studentResponseDto = mapentityToDto(createdStudent);
        return studentResponseDto;

    }

    public StudentResponseDto getStudent(Long Id){
        Optional<Student> student= studentRepository.findByIdAndDeletedIsFalse(Id);
        if(student.isPresent())
           return mapentityToDto(student.get());
        return null;
    }

    public List<StudentResponseDto> getAllStudents(){
        List<Student> student= studentRepository.findByAndDeletedIsFalse();
        return student.stream()
                .map(this::mapentityToDto)
                .toList();
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
    public String softDeleteStudent(Long id){
     Optional<Student> student= studentRepository.findByIdAndDeletedIsFalse(id);
     if(student.isEmpty()) return "";
     Student exsistingStudent= student.get();
     exsistingStudent.setDeleted(true);
     studentRepository.save(exsistingStudent);
     return "Successfully Deleted softly";
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
}


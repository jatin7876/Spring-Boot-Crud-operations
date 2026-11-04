package in.jatint4r.springbootcrudoperations.controller;

import in.jatint4r.springbootcrudoperations.dto.StudentRequestDto;
import in.jatint4r.springbootcrudoperations.dto.StudentResponseDto;
import in.jatint4r.springbootcrudoperations.entity.Student;
import in.jatint4r.springbootcrudoperations.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentServic){

        this.studentService = studentServic;
    }

    @PostMapping("/created")
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto studentResponseDto= studentService.createnewStudent(studentRequestDto);
        return ResponseEntity.status(201).body(studentResponseDto);
    }

    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
      Student student = studentService.getStudent(id);
      if(student==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      return ResponseEntity.ok(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> student = studentService.getAllStudents();
        if(student.isEmpty())
            return ResponseEntity.status(404).body(null);
        return ResponseEntity.status(200).body(student);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id,@RequestBody Student studentReq){
        Student student = studentService.updateStudent(id,studentReq);
        return ResponseEntity.status(201).body(student);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteStudent(@RequestParam Long id){
        Boolean deleted = studentService.deleteStudent(id);
        if(!deleted) return ResponseEntity.status(404).body(null);
        return ResponseEntity.ok(deleted);
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
        String student= studentService.softDeleteStudent(id);
        if(student.isEmpty()) return  ResponseEntity.status(404).body("No Id found");
       return ResponseEntity.status(200).body(student);
    }
}

package in.jatint4r.springbootcrudoperations.controller;

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
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student newstudent= studentService.createnewStudent(student);
        return ResponseEntity.status(201).body(newstudent);
    }

    @GetMapping("/get/{Id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long Id){
      Student student = studentService.getStudent(Id);
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
}

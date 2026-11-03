package in.jatint4r.springbootcrudoperations.controller;

import in.jatint4r.springbootcrudoperations.entity.Student;
import in.jatint4r.springbootcrudoperations.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentServic){
        this.studentService = studentServic;
    }
    @PostMapping("/created")
    public Student createStudent(@RequestBody Student student){
        Student newstudent= studentService.createnewStudent(student);
        return newstudent;
    }
}

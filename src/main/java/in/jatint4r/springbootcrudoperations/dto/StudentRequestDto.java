package in.jatint4r.springbootcrudoperations.dto;

import jakarta.validation.constraints.*;

public class StudentRequestDto {
    @NotBlank(message= "Name should not be blank")
    private String name;

    @Min(value = 18,message = "Age is Required")
    private Integer age;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Subject cannot be blank")
    private String subject;

    @NotNull(message = "RollNo cannot be blank")
    private Integer rollNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}

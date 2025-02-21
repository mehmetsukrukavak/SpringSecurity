package com.mehmetsukrukavak.SpringSecurity.controller;

import com.mehmetsukrukavak.SpringSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
       new Student(1,"Mehmet","C#"),
       new Student(2,"Esra", "Photoshop")

    ));

    @GetMapping("/csrf-token")
    public CsrfToken csrfToken(HttpServletRequest request) {
            return (CsrfToken) request.getAttribute("_csrf");
    }
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }
}

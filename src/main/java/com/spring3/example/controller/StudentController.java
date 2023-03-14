package com.spring3.example.controller;

import com.spring3.example.model.Student;
import com.spring3.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Snehasis Mondal
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return StudentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return StudentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(String id){
        return StudentService.getStudents(id);
    }

}

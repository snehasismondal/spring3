package com.spring3.example.service;

import com.spring3.example.model.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Snehasis Mondal
 */
@Service
public class StudentService {
    static List<Student> studentList =new ArrayList<>();

    //Observability
    @Autowired
    private static ObservationRegistry observationRegistry;

    public static Student addStudent(Student student) {
        studentList.add(student);
        //return student;
        return Observation.createNotStarted("addStudent",observationRegistry)
                .observe(()->student);
    }

    public static List<Student> getAllStudents() {
        //return studentList;
        return Observation.createNotStarted("getAllStudents",observationRegistry)
                .observe(()->studentList);
    }

    public static Student getStudents(String id) {
        return studentList.stream().filter(s->s.id().equals(id))
                .findFirst().orElseThrow(()->new RuntimeException("Student is not available") );
    }
}

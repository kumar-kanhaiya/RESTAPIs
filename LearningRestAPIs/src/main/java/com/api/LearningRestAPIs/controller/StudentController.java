package com.api.LearningRestAPIs.controller;


import com.api.LearningRestAPIs.dto.StudentDto;
import com.api.LearningRestAPIs.entity.Student;
import com.api.LearningRestAPIs.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(){
        return new StudentDto(4L,"krishna","krish@gmail.com");
    }

//    Configuration config = new Configuration().configure().addAnnotatedClass(StudentDto.class);
//
//    SessionFactory sessionFactory = config.buildSessionFactory();
//
//    Session session = sessionFactory.openSession();

}

package com.api.LearningRestAPIs.controller;


import com.api.LearningRestAPIs.dto.StudentDto;

import com.api.LearningRestAPIs.service.StudentService;
import com.api.LearningRestAPIs.service.impl.StudentServiceImp;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

//    public StudentController(StudentRepository studentRepository){
//        this.studentRepository = studentRepository;
//    }

    @GetMapping("/student")
    public List<StudentDto> getStudent(){
        return studentService.getAllStudent();
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

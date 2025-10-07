package com.api.LearningRestAPIs.controller;


import com.api.LearningRestAPIs.dto.StudentDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(4L,"Kanhaiya" , "kanhaiya@gmail.com");
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

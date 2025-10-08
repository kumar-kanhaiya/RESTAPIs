package com.api.LearningRestAPIs.service;

import com.api.LearningRestAPIs.dto.AddStudentRequestDto;
import com.api.LearningRestAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudent();


    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto student);

    void deleteById(long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

}

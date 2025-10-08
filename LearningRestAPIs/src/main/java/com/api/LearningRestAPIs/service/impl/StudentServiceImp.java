package com.api.LearningRestAPIs.service.impl;

import com.api.LearningRestAPIs.dto.StudentDto;
import com.api.LearningRestAPIs.entity.Student;
import com.api.LearningRestAPIs.repository.StudentRepository;
import com.api.LearningRestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImp  implements StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> list = students
                .stream()
                .map(student -> new
                StudentDto(
                        student.getId(),
                        student.getName() ,
                        student.getEmail()))
                .toList();
        return list;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student =  studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));

        StudentDto studentDto = modelMapper.map(student,StudentDto.class);

        return studentDto;

    }


}

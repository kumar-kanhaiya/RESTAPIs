package com.api.LearningRestAPIs.service.impl;

import com.api.LearningRestAPIs.dto.AddStudentRequestDto;
import com.api.LearningRestAPIs.dto.StudentDto;
import com.api.LearningRestAPIs.entity.Student;
import com.api.LearningRestAPIs.repository.StudentRepository;
import com.api.LearningRestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

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

        return modelMapper.map(student,StudentDto.class);

    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto,Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteById(@PathVariable  long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist by Id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID" + id));

        modelMapper.map(addStudentRequestDto , student);

        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID" + id));

        updates.forEach((field,value) -> {
            switch (field){
                case "name": student.setName((String) value);
                case "email": student.setEmail((String) value);
                default:
                    throw new IllegalArgumentException("field is not supported");
            }
        } );

        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent,StudentDto.class);
    }


}

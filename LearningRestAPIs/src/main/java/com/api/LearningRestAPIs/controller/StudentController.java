package com.api.LearningRestAPIs.controller;


import com.api.LearningRestAPIs.dto.AddStudentRequestDto;
import com.api.LearningRestAPIs.dto.StudentDto;

import com.api.LearningRestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

//    public StudentController(StudentRepository studentRepository){
//        this.studentRepository = studentRepository;
//    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent(){
//        return studentService.getAllStudent();
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
//        return studentService.getStudentById(id);
        return ResponseEntity.ok((studentService.getStudentById(id)));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService
                .createNewStudent(student));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id
            , @RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id , addStudentRequestDto));
    }

    @PatchMapping("/{id}")


}

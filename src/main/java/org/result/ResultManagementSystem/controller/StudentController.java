package org.result.ResultManagementSystem.controller;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.StudentDto;
import org.result.ResultManagementSystem.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequestMapping("/students")
@RestController
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;
    //Build Add Students REST API
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
       StudentDto savedStudent= studentService.createStudent(studentDto);
       return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    //Build GET Students REST API
    @GetMapping("{id}")
    public  ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId){
        StudentDto studentDto=studentService.getStudentById(studentId);
        return  new ResponseEntity<>(studentDto,HttpStatus.OK);
    }

    //Build API to Get ALL Student
    @GetMapping
    public  ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> studentDtos=studentService.getAllStudent();
        return  new ResponseEntity<>(studentDtos,HttpStatus.OK);
    }

    //Build REST API to Update Students
    @PutMapping("{id}")
    public  ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long StudentId,@RequestBody StudentDto studentDto){
        StudentDto studentDto1=studentService.updateStudent(studentDto,StudentId);
        return new ResponseEntity<>(studentDto1,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>("Student Deleted Successfully !",HttpStatus.OK);
    }
}

package org.result.ResultManagementSystem.service;

import org.result.ResultManagementSystem.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long studentId);
    List<StudentDto> getAllStudent();
    StudentDto updateStudent(StudentDto studentDto,Long StudentId);
    void deleteStudent(Long studentId);

}
